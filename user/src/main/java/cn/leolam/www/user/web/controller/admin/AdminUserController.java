package cn.leolam.www.user.web.controller.admin;

import cn.leolam.www.user.web.entities.HttpResult;
import cn.leolam.www.user.web.entities.User;
import cn.leolam.www.user.web.service.admin.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/admin/user")
@Controller
@PreAuthorize("hasAnyAuthority('admin')")
public class AdminUserController {
    @Autowired
    AdminUserService adminUserService;

    /**
     * 获取所有的用户
     * @param page
     * @return
     */
    @GetMapping("/getUsers")
    @ResponseBody
    public HttpResult getUsers(@RequestParam("page") Integer page){
        return HttpResult.ok("success",adminUserService.getUsers(page));
    }

    /**
     * 获取一共有多少用户
     * @return
     */
    @GetMapping("/getUsersCount")
    @ResponseBody
    public HttpResult getUsersCount(){
        return HttpResult.ok("success",adminUserService.getUsersCount());
    }

    /**
     * 新增一名用户
     * @param user
     * @return
     */
    @PostMapping("/insertUser")
    @ResponseBody
    public HttpResult insertUser(@RequestBody User user){
        adminUserService.insertUser(user);
        return HttpResult.ok("success");
    }

    /**
     * 删除一名用户
     * @param userId
     * @param request
     * @return
     */
    @GetMapping("/deleteUser")
    @ResponseBody
    public HttpResult deleteUser(@RequestParam("userId") Integer userId, HttpServletRequest request){
        adminUserService.deleteUser(Long.parseLong(String.valueOf(userId)),request);
        return HttpResult.ok("success");
    }

    /**
     * 更新一名用户
     * @param user
     * @return
     */
    @PostMapping("/updateUser")
    @ResponseBody
    public HttpResult updateUser(@RequestBody User user){
        adminUserService.updateUser(user);
        return HttpResult.ok("success");
    }

}
