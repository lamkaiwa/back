package cn.leolam.www.video.web.controller.search;

import cn.leolam.www.video.web.entities.HttpResult;
import cn.leolam.www.video.web.entities.Video;
import cn.leolam.www.video.web.service.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    SearchService searchService;

    /**
     * 获取top视频
     * @param words
     * @param page
     * @param sortBy
     * @return
     */
    @GetMapping("/searchVideos")
    @ResponseBody
    public HttpResult search(@RequestParam("words") String words, @RequestParam("page") Integer page, @RequestParam("sortBy") String sortBy){
        List<Video> videos=searchService.getSearchVideoByLikeSortType(page,words,sortBy);
        return HttpResult.ok("success",videos);
    }

    @GetMapping("/searchCount")
    @ResponseBody
    public HttpResult searchCount(@RequestParam("words") String words){
        Integer count = searchService.getSearchVideoCountByLikeUserId(words,null);
        return HttpResult.ok("success",count);
    }
}
