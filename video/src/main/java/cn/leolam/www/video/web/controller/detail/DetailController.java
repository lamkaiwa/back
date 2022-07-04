package cn.leolam.www.video.web.controller.detail;

import cn.leolam.www.video.web.entities.*;
import cn.leolam.www.video.web.service.detail.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("/detail")
@Controller
public class DetailController {
    @Autowired
    DetailService detailService;

    /**
     * 获取视频的信息
     *
     * @param videoId
     * @return
     */
    @GetMapping("/getVideoByVideoId")
    @ResponseBody
    public HttpResult getVideoByVideoId(@RequestParam Integer videoId, HttpServletRequest request) {
        Video video = detailService.getVideoByVideoId(videoId, request);
        return HttpResult.ok("success", video);
    }

    /**
     * 获取推荐的视频
     *
     * @param title
     * @param desc
     * @param request
     * @return
     */
    @GetMapping("/getRecommendVideoByWord")
    @ResponseBody
    public HttpResult getRecommendVideoByWord(@RequestParam("title") String title, @RequestParam("desc") String desc, HttpServletRequest request) {
        List<Video> videoList = detailService.getRecommendVideosByWord(0, title, desc, null, null, request);
        return HttpResult.ok("success", videoList);
    }

    /**
     * 获取一个视频全部的bytes
     *
     * @param type
     * @param fileName
     * @param response
     */
    @GetMapping("/getVideoBytes")
    public void getVideoBytes(@RequestParam("type") Integer type, @RequestParam("fileName") String fileName, HttpServletResponse response) {
        detailService.getVideoBytes(Integer.toString(type), fileName, response);
    }

    /**
     * 播放量加一
     *
     * @param videoId
     * @return
     */
    @GetMapping("/updateVideoPlayCount")
    @ResponseBody
    public HttpResult updateVideoPlayCount(@RequestParam("videoId") Integer videoId) {
        detailService.updateVideoPlayCountByVideoId(videoId);
        return HttpResult.ok("success");
    }

    /**
     * 获取视频的block
     *
     * @param response
     * @param type
     * @param block
     * @param videoName
     */
    @GetMapping("/getVideoBlock")
    public void getVideoBlock(HttpServletResponse response,
                              @RequestParam("type") Integer type,
                              @RequestParam("block") Integer block,
                              @RequestParam("videoName") String videoName
    ) {
        detailService.readVideoBlock(type, videoName, block, response);
    }

    /**
     * 获取视频的信息
     *
     * @param type
     * @param fileName
     * @return
     */
    @GetMapping("/getVideoInfo")
    @ResponseBody
    public HttpResult getVideoInfo(@RequestParam("type") Integer type, @RequestParam("fileName") String fileName) {
        VideoInfo videoInfo = detailService.getVideoInfo(type, fileName);
        return HttpResult.ok("success", videoInfo);
    }

    /**
     * 获取视频特定时间内的图片
     *
     * @param type
     * @param videoName
     * @param time
     * @param response
     */
    @GetMapping("/getImageBytesOnSpecifiedTime")
    @ResponseBody
    public void getImageBytesOnSpecifiedTime(@RequestParam("type") Integer type, @RequestParam("videoName") String videoName, @RequestParam("time") String time, HttpServletResponse response) {
        detailService.getImageBytesOnSpecifiedTime(type, videoName, time, response);
    }

    /**
     * 查看用户是否有点赞
     *
     * @param zanList
     * @return
     */
    @PostMapping("/isZan")
    @ResponseBody
    public HttpResult isZan(@RequestBody ZanList zanList) {
        Integer integer = detailService.isZan(zanList);
        boolean flag = true;
        if (integer != 1) {
            flag = false;
        }
        return HttpResult.ok("success", flag);
    }

    /**
     * 查看用户是否有收藏
     * @param collectionList
     * @return
     */
    @PostMapping("/isCollectionList")
    @ResponseBody
    public HttpResult isCollectionList(@RequestBody CollectionList collectionList) {
        Integer integer = detailService.isCollectionList(collectionList);
        boolean flag = true;
        if (integer != 1) {
            flag = false;
        }
        return HttpResult.ok("success", flag);
    }

    /**
     * 点赞
     * @param zanList
     * @return
     */
    @PostMapping("/addZan")
    @ResponseBody
    public HttpResult addZan(@RequestBody ZanList zanList) {
        Integer integer = detailService.addZan(zanList);
        boolean flag = true;
        if (integer != 1) {
            flag = false;
        }
        return HttpResult.ok("success", flag);
    }

    /**
     * 收藏
     * @param collectionList
     * @return
     */
    @PostMapping("/addCollection")
    @ResponseBody
    public HttpResult addCollection(@RequestBody CollectionList collectionList) {
        Integer integer = detailService.addCollection(collectionList);
        boolean flag = true;
        if (integer != 1) {
            flag = false;
        }
        return HttpResult.ok("success", flag);
    }

    /**
     * 取消点赞
     * @param zanList
     * @return
     */
    @PostMapping("/deleteZan")
    @ResponseBody
    public HttpResult deleteZan(@RequestBody ZanList zanList) {
        Integer integer = detailService.deleteZan(zanList);
        boolean flag = true;
        if (integer != 1) {
            flag = false;
        }
        return HttpResult.ok("success", flag);
    }

    /**
     * 取消收藏
     * @param collectionList
     * @return
     */
    @PostMapping("/deleteCollection")
    @ResponseBody
    public HttpResult deleteCollection(@RequestBody CollectionList collectionList) {
        Integer integer = detailService.deleteCollection(collectionList);
        boolean flag = true;
        if (integer != 1) {
            flag = false;
        }
        return HttpResult.ok("success", flag);
    }

}
