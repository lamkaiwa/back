package cn.leolam.www.video.web.service.impl.detail;

import cn.leolam.www.video.exception.detail.DetailException;
import cn.leolam.www.video.properties.VideoProperties;
import cn.leolam.www.video.web.entities.*;
import cn.leolam.www.video.web.mapper.CollectionListMapper;
import cn.leolam.www.video.web.mapper.VideoMapper;
import cn.leolam.www.video.web.mapper.ZanListMapper;
import cn.leolam.www.video.web.service.detail.DetailService;
import cn.leolam.www.video.web.utils.FFMPEGUtils;
import cn.leolam.www.video.web.utils.MPDUtils;
import cn.leolam.www.video.web.utils.RestTemplateUtils;
import cn.leolam.www.video.web.utils.VideoUtils;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@Transactional
public class DetailServiceImpl implements DetailService {
    @Autowired
    VideoMapper videoMapper;

    @Autowired
    ZanListMapper zanListMapper;

    @Autowired
    CollectionListMapper collectionListMapper;

    @Autowired
    RestTemplateUtils restTemplateUtils;

    @Autowired
    VideoProperties videoProperties;

    @Autowired
    VideoUtils videoUtils;

    @Autowired
    MPDUtils mpdUtils;

    @Autowired
    FFMPEGUtils ffmpegUtils;

    @Override
    public Video getVideoByVideoId(Integer videoId, HttpServletRequest request) {
        Video video = null;
        try {
            video = videoMapper.getVideoById(videoId);
            HttpHeaders headers = new HttpHeaders();
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            headers.add("Authorization", request.getHeader("Authorization"));
            params.add("id", String.valueOf(video.getAuthor()));
            ResponseEntity<Map> responseEntity = restTemplateUtils.sendToAuthGetUserToken("/user/mine/setting/getUserById", headers, params);
            Map<String, String> map = responseEntity.getBody();
            String json = JSONObject.toJSONString(map.get("data"));
            User user = JSONObject.parseObject(json, User.class);
            video.setAuthor(user);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new DetailException("视频资料获取失败");
        }

        return video;
    }


    @Override
    public List<Video> getRecommendVideosByWord(Integer page, String title, String desc, String sortType, Integer userId, HttpServletRequest request) {
        List<Video> videoList = null;
        try {
            Integer end = videoProperties.getPageSizeOnSearchPage();
            //获取推荐的视频
            videoList = videoMapper.getRecommendVideoByTwoWordsAndSortType(page, end, title, sortType, null, desc);
            if (videoList.size() != videoProperties.getPageSizeOnDetailPage()) {
                end = videoProperties.getPageSizeOnDetailPage() - videoList.size();
                List<Video> videoList1 = videoMapper.getSearchVideoByLikeSortTypeUserId(page, end, null, "playCount", userId);
                videoList.addAll(videoList1);
            }
            //获取author
            int length = videoList.size();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", request.getHeader("Authorization"));
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            for (int i = 0; i < length; i++) {
                params.add("id", String.valueOf(videoList.get(i).getAuthor()));
                ResponseEntity<Map> responseEntity = restTemplateUtils.sendToAuthGetUserToken("/user/mine/setting/getUserById", headers, params);
                Map<String, String> map = responseEntity.getBody();
                String json = JSONObject.toJSONString(map.get("data"));
                User user = JSONObject.parseObject(json, User.class);
                videoList.get(i).setAuthor(user);
                params.clear();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new DetailException("获取推荐视频失败");
        }
        return videoList;
    }

    @Override
    public void getVideoBytes(String dir, String fileName, HttpServletResponse response) {
        try {
            byte[] bytes = videoUtils.getVideoBytes(dir, fileName);
            setVideoHeader(response);
            sendVideoBytes(response, bytes);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new DetailException("获取视频数据失败");
        }
    }


    @Override
    public Integer updateVideoPlayCountByVideoId(Integer videoId) {
        try {
            Integer integer = videoMapper.updateVideoPlayCountByVideoId(videoId);
            if (integer != 1) {
                throw new DetailException("播放量加一失败");
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new DetailException("播放量加一失败");
        }
        return 1;
    }


    @Override
    public void readVideoBlock(Integer type, String fileName, Integer block, HttpServletResponse response) {
        try {
            //读取videoMpd
            VideoInfo videoInfo = mpdUtils.ReadVideoMPD(Integer.toString(type), fileName);
            //读取当前block的范围
            String[] blocks = videoInfo.getSegment().get(block);
            int start = Integer.parseInt(blocks[0]);
            //video特性  需要比原来多一
            int end = Integer.parseInt(blocks[1]) + 1;
            byte[] bytes = videoUtils.videoUtilVideoClipToBytes(Integer.toString(type), fileName, start, end);
            log.info("读取：" + start + " " + end + "长度是:" + bytes.length);
            setVideoHeader(response, videoInfo, bytes.length);
            response.getOutputStream().write(bytes);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new DetailException("获取视频block失败");
        }
    }


    @Override
    public VideoInfo getVideoInfo(Integer type, String fileName) {
        VideoInfo videoInfo = null;
        try {
            videoInfo = mpdUtils.ReadVideoMPD(Integer.toString(type), fileName);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new DetailException("获取视频资料失败");
        }
        return videoInfo;
    }

    @Override
    public void getImageBytesOnSpecifiedTime(Integer type, String videoName, String time, HttpServletResponse response) {
        try {
            byte[] bytes = ffmpegUtils.getImageBytesOnSpecifiedTime(Integer.toString(type), videoName, time);
            setImageResponseHeader(response);
            response.getOutputStream().write(bytes);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new DetailException("获取特地时间段图片失败");
        }
    }

    //设置图片响应头
    private void setImageResponseHeader(HttpServletResponse response) {
        response.setHeader("Content-Type", "image/jpeg");
        response.setHeader("cache-control", "max-age=12000");
    }

    /**
     * 设置video响应头信息
     *
     * @param response
     * @param videoInfo
     * @param length
     */
    private void setVideoHeader(HttpServletResponse response, VideoInfo videoInfo, Integer length) {
        response.setHeader("Content-Type", videoInfo.getMimeType());
        response.setHeader("Content-length", Integer.toString(length));
        response.setHeader("cache-control", "max-age=1200");
    }

    /**
     * 发送video bytes
     *
     * @param response
     * @param bytes
     * @throws IOException
     */
    private void sendVideoBytes(HttpServletResponse response, byte[] bytes) throws IOException {
        ServletOutputStream servletOutputStream = response.getOutputStream();
        servletOutputStream.write(bytes);
        servletOutputStream.flush();
        servletOutputStream.close();
    }

    /**
     * 设置video响应头
     *
     * @param response
     */
    private void setVideoHeader(HttpServletResponse response) {
        response.setHeader("Content-Type", "video/mp4");
    }


    @Override
    public Integer addZan(ZanList zanList) {
        Integer integer = null;
        try {
            integer = zanListMapper.insertZanListByZanList(zanList);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new DetailException("添加赞失败");
        }
        return integer;
    }

    @Override
    public Integer addCollection(CollectionList collectionList) {
        Integer integer = null;
        try {
            integer = collectionListMapper.insertCollectionListByCollectionList(collectionList);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new DetailException("添加收藏失败");
        }
        return integer;
    }

    @Override
    public Integer isZan(ZanList zanList) {
        Integer integer = null;
        try {
            integer = zanListMapper.getZanListCountByZanList(zanList);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new DetailException("获取点赞失败");
        }
        return integer;
    }

    @Override
    public Integer isCollectionList(CollectionList collectionList) {
        Integer integer = null;
        try {
            integer =collectionListMapper.getCollectionListCountByCollectionList(collectionList);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new DetailException("获取是否收藏失败");
        }
        return integer;
    }

    @Override
    public Integer deleteZan(ZanList zanList) {
        Integer integer = null;
        try {
            integer = zanListMapper.deleteZanListByZanList(zanList);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new DetailException("删除点赞失败");
        }
        return integer;
    }

    @Override
    public Integer deleteCollection(CollectionList collectionList) {
        Integer integer = null;
        try {
            integer = collectionListMapper.deleteCollectionListByCollectionList(collectionList);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new DetailException("取消关注失败");
        }
        return integer;
    }
}
