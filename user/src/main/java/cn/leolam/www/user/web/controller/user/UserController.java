package cn.leolam.www.user.web.controller.user;

import cn.leolam.www.user.web.entities.Attention;
import cn.leolam.www.user.web.entities.HttpResult;
import cn.leolam.www.user.web.entities.Video;
import cn.leolam.www.user.web.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 查看是否有关注
     *
     * @param attention
     * @return
     */
    @PostMapping("/isAttention")
    @ResponseBody
    public HttpResult isAttention(@RequestBody Attention attention) {
        return HttpResult.ok("success", userService.isAttention(attention));
    }

    /**
     * 取消关注
     *
     * @param attention
     * @return
     */
    @PostMapping("/cancelAttention")
    @ResponseBody
    public HttpResult cancelAttention(@RequestBody Attention attention) {
        userService.cancelAttention(attention);
        return HttpResult.ok("取消关注成功");
    }

    /**
     * 添加关注
     *
     * @param attention
     * @return
     */
    @PostMapping("/addAttention")
    @ResponseBody
    public HttpResult addAttention(@RequestBody Attention attention) {
        userService.addAttention(attention);
        return HttpResult.ok("添加关注成功");
    }

    /**
     * 获取用户上传了的视频
     * @param words
     * @param page
     * @param sortBy
     * @param userId
     * @return
     */
    @GetMapping("/getVideoPageByUser")
    @ResponseBody
    public HttpResult search(@RequestParam("words") String words,
                             @RequestParam("page") Integer page,
                             @RequestParam("sortBy") String sortBy,
                             @RequestParam("userId") Integer userId,
                             HttpServletRequest request
    ){
        List<Video> videos=userService.getSearchVideoByLikeSortTypeUserId(page,words,sortBy,userId,request);
        return HttpResult.ok("success",videos);
    }

    /**
     * 获取个人上传的视频的总数
     * @param words
     * @param userId
     * @return
     */

    @GetMapping("/searchCount")
    @ResponseBody
    public HttpResult searchCount(@RequestParam("words") String words,@RequestParam("userId")Integer userId,HttpServletRequest request){
        Integer count = userService.getSearchVideoCountByLikeUserId(words,userId,request);
        return HttpResult.ok("success",count);
    }


}
