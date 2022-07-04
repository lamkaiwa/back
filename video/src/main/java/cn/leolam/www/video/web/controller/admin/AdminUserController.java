package cn.leolam.www.video.web.controller.admin;

import cn.leolam.www.video.web.entities.HttpResult;
import cn.leolam.www.video.web.service.admin.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/admin/user")
@Controller
@PreAuthorize("hasAnyAuthority('admin')")
public class AdminUserController {
    @Autowired
    AdminUserService adminUserService;

    /**
     * 删除该用户有关的视频信息
     * @param id
     * @return
     */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public HttpResult deleteUser(@RequestParam("userId") Long id){
        adminUserService.deleteUser(id);
        return HttpResult.ok("success");
    }
}
