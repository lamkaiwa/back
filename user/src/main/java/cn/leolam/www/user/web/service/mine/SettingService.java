package cn.leolam.www.user.web.service.mine;

import cn.leolam.www.user.web.entities.User;
import org.springframework.web.multipart.MultipartFile;

public interface SettingService {
    /**
     * 获取用户信息
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 上传头像
     * @param file
     * @param userId
     * @return
     */
    String uploadAvatar(MultipartFile file, Integer userId);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    Integer updateUserByUserId(User user);
}
