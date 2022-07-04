package cn.leolam.www.user.web.controller.mine;

import cn.leolam.www.user.web.entities.HttpResult;
import cn.leolam.www.user.web.entities.User;
import cn.leolam.www.user.web.service.mine.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/mine/setting")
public class SettingController {
    @Autowired
    SettingService settingService;
    /**
     * 查找用户信息
     * @param id
     * @return
     */
    @RequestMapping("/getUserById")
    @ResponseBody
    public HttpResult getUserById(@RequestParam("id") Integer id){
        return HttpResult.ok("success",settingService.getUserById(id));
    }
    /**
     * 上传头像
     * @param id
     * @param file
     * @return 新的头像名称
     */
    @PostMapping("/uploadAvatar")
    @ResponseBody
    public HttpResult uploadAvatar(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer id){
        return HttpResult.ok("success",settingService.uploadAvatar(file,id));
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @PostMapping("/updateUserByUserId")
    @ResponseBody
    public HttpResult updateUserByUserId(@RequestBody User user){
        settingService.updateUserByUserId(user);
        return HttpResult.ok("success");
    }


}
