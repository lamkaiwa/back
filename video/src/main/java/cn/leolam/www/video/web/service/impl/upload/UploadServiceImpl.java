package cn.leolam.www.video.web.service.impl.upload;

import cn.leolam.www.video.exception.upload.UploadException;
import cn.leolam.www.video.web.entities.Video;
import cn.leolam.www.video.web.mapper.VideoMapper;
import cn.leolam.www.video.web.service.upload.UploadService;
import cn.leolam.www.video.web.utils.ImageUtils;
import cn.leolam.www.video.web.utils.Mp4BoxUtils;
import cn.leolam.www.video.web.utils.VideoUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
@Slf4j
@Transactional
public class UploadServiceImpl implements UploadService {
    @Autowired
    VideoMapper videoMapper;

    @Autowired
    Mp4BoxUtils mp4BoxUtils;

    @Autowired
    ImageUtils imageUtils;
    @Autowired
    VideoUtils videoUtils;

    @Override
    public void uploadVideo(MultipartFile video, MultipartFile image, Integer type, String desc, String title, String author, String uuid, Integer size, Integer end) {
        try {
            //第一个请求
            if (image != null) {
                imageUtils.createDownLoadFile(String.valueOf(type), uuid);
                videoUtils.createDownLoadFile(String.valueOf(type), uuid);
                //写入image
                FileUtils.writeByteArrayToFile(new File(imageUtils.getFilePath(String.valueOf(type), uuid)), image.getBytes());
            }
            //写入video
            FileUtils.writeByteArrayToFile(new File(videoUtils.getFilePath(String.valueOf(type), uuid)), video.getBytes(),true);
            //最后一个请求
            if (end.equals(size)) {
                //创建dash mp4文件
                mp4BoxUtils.createDashMp4(String.valueOf(type),uuid);
                //删除以前的video文件
                videoUtils.deleteFile(String.valueOf(type),uuid);
                Video video1 = new Video();
                video1.setPlayCount(Long.parseLong("100"));
                video1.setAuthor(author);
                video1.setTitle(title);
                video1.setType(Long.parseLong(String.valueOf(type)));
                video1.setDesc(desc);
                video1.setVideoName(uuid);
                video1.setImageName(uuid);
                videoMapper.insertVideoByVideo(video1);
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new UploadException("上传失败", String.valueOf(type), uuid);
        }
    }
}
