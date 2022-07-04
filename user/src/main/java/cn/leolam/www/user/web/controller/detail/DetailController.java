package cn.leolam.www.user.web.controller.detail;

import cn.leolam.www.user.web.entities.Comment;
import cn.leolam.www.user.web.entities.HttpResult;
import cn.leolam.www.user.web.entities.Message;
import cn.leolam.www.user.web.service.detail.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/detail")
@Controller
public class DetailController {
    @Autowired
    DetailService detailService;

    /**
     * 获取评论信息
     *
     * @param videoId
     * @return
     */
    @GetMapping("/getVideoComments")
    @ResponseBody
    public HttpResult getVideoComments(@RequestParam("videoId") Integer videoId) {
        List<Comment> commentList = detailService.getVideoComments(videoId);
        return HttpResult.ok("success", commentList);
    }

    /**
     * 发送评论
     *
     * @param comment
     * @return
     */
    @PostMapping("/sendComment")
    @ResponseBody
    public HttpResult sendComment(@RequestBody Comment comment) {
        Integer res = detailService.addComment(comment);
        return HttpResult.ok("success", res == 1 ? true : false);

    }

    /**
     * 获取评论的数目
     *
     * @param videoId
     * @return
     */
    @GetMapping("/getCommentCount")
    @ResponseBody
    public HttpResult getCommentCount(@RequestParam("videoId") Long videoId) {
        return HttpResult.ok("success", detailService.getCommentCount(videoId));
    }

    /**
     * 添加回复
     *
     * @param message
     * @return
     */
    @PostMapping("/addReply")
    @ResponseBody
    public HttpResult addReply(@RequestBody Message message) {
        Integer res = detailService.addReply(message);
        return HttpResult.ok("success", res == 1 ? true : false);
    }

    /**
     * 删除评论和回复
     * @param commentId
     * @param replyId
     * @return
     */
    @GetMapping("/deleteCommentAndReply")
    @ResponseBody
    public HttpResult deleteCommentAndReply(@RequestParam(value = "commentId",required = true) Long commentId,@RequestParam(value = "replyId",required = false) Long replyId) {
        if(replyId == null) detailService.deleteComment(commentId);
        else detailService.deleteReply(replyId);
        return HttpResult.ok("success");
    }


}
