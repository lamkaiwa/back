package cn.leolam.www.video.web.controller.mine;

import cn.leolam.www.video.web.entities.CollectionList;
import cn.leolam.www.video.web.entities.HttpResult;
import cn.leolam.www.video.web.entities.Video;
import cn.leolam.www.video.web.service.mine.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/mine/collection")
@Controller
public class CollectionController {
    @Autowired
    CollectionService collectionService;

    /**
     * 获取用户收藏了那些视频
     *
     * @param userId
     * @param request
     * @return
     */
    @GetMapping("/getCollectionVideoListByUserId")
    @ResponseBody
    public HttpResult getCollectionVideoListByUserId(@RequestParam("userId") Integer userId, @RequestParam("page") Integer page, HttpServletRequest request) {
        List<Video> videoList = collectionService.getCollectionVideoListByUserId(userId, page, request);
        return HttpResult.ok("success", videoList);
    }

    /**
     * 获取收藏的总数
     * @param userId
     * @return
     */
    @GetMapping("/getAttentionCountByUserId")
    @ResponseBody
    public HttpResult getAttentionCountByUserId(@RequestParam("userId") Integer userId){
        Integer count= collectionService.getAttentionCountByUserId(userId);
        return HttpResult.ok("success",count);
    }

    /**
     * 取消收藏
     * @param collectionList
     * @return
     */
    @PostMapping("/deleteCollectionListByVideoIdAndUserId")
    @ResponseBody
    public HttpResult deleteCollectionListByVideoIdAndUserId(@RequestBody CollectionList collectionList){
        collectionService.deleteCollectionListByVideoIdAndUserId(collectionList);
        return HttpResult.ok("success");
    }
}
