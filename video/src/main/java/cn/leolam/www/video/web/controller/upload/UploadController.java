package cn.leolam.www.video.web.controller.upload;

import cn.leolam.www.video.web.entities.HttpResult;
import cn.leolam.www.video.web.service.upload.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/upload")
@Controller
public class UploadController {
    @Autowired
    UploadService uploadService;

    /**
     * 分片上传视频
     * @param video
     * @param image
     * @param type
     * @param desc
     * @param title
     * @param author
     * @param uuid
     * @param size
     * @param end
     * @return
     */
    @PostMapping("/uploadVideo")
    @ResponseBody
    public HttpResult uploadVideo(@RequestParam("video") MultipartFile video,
                                  @RequestParam(value = "image", required = false) MultipartFile image,
                                  @RequestParam("type") Integer type,
                                  @RequestParam("desc") String desc,
                                  @RequestParam("title") String title,
                                  @RequestParam("author") String author,
                                  @RequestParam("uuid") String uuid,
                                  @RequestParam("size") Integer size,
                                  @RequestParam("end") Integer end

    ) {
        uploadService.uploadVideo(video,image,type,desc,title,author,uuid,size,end);
        return HttpResult.ok("success");
    }
}
