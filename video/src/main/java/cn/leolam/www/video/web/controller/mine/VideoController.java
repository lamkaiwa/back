package cn.leolam.www.video.web.controller.mine;

import cn.leolam.www.video.web.entities.HttpResult;
import cn.leolam.www.video.web.entities.Video;
import cn.leolam.www.video.web.service.mine.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/mine/video")
@Controller
public class VideoController {
    @Autowired
    VideoService videoService;

    /**
     * 获取用户上传了的视频
     * @param words
     * @param page
     * @param sortBy
     * @param userId
     * @return
     */
    @RequestMapping("/getVideoPageByUser")
    @ResponseBody
    public HttpResult search(@RequestParam("words") String words,
                             @RequestParam("page") Integer page,
                             @RequestParam("sortBy") String sortBy,
                             @RequestParam("userId") Integer userId
    ){
        List<Video> videos=videoService.getSearchVideoByLikeSortTypeUserId(page,words,sortBy,userId);
        return HttpResult.ok("success",videos);
    }

    /**
     * 获取个人上传的视频的总数
     * @param words
     * @param userId
     * @return
     */

    @RequestMapping("/searchCount")
    @ResponseBody
    public HttpResult searchCount(@RequestParam("words") String words,@RequestParam("userId")Integer userId){
        Integer count = videoService.getSearchVideoCountByLikeUserId(words,userId);
        return HttpResult.ok("success",count);
    }

    /**
     * 删除一个视频
     * @param videId
     * @return
     */
    @GetMapping("/deleteVideoById")
    @ResponseBody
    public HttpResult deleteVideoById(@RequestParam("videoId") Integer videId){
        videoService.deleteVideoById(videId);
        return HttpResult.ok("success");
    }
}
