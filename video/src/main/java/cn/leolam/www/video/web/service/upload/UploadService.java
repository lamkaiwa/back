package cn.leolam.www.video.web.service.upload;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    /**
     * 上传图片
     * @param video
     * @param image
     * @param type
     * @param desc
     * @param title
     * @param author
     * @param uuid
     * @param size
     * @param end
     */
    void uploadVideo(MultipartFile video,
                     MultipartFile image,
                     Integer type,
                     String desc,
                     String title,
                     String author,
                     String uuid,
                     Integer size,
                     Integer end
    );
}
