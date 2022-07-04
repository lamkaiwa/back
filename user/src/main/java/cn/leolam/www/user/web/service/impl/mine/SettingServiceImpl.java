package cn.leolam.www.user.web.service.impl.mine;

import cn.leolam.www.user.exception.mine.SettingException;
import cn.leolam.www.user.web.entities.User;
import cn.leolam.www.user.web.mapper.UserMapper;
import cn.leolam.www.user.web.service.mine.SettingService;
import cn.leolam.www.user.web.utils.ImageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Service
@Slf4j
@Transactional
public class SettingServiceImpl implements SettingService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        User user = null;
        try {
            User user1 = new User();
            user1.setId(new Long(id));
            user = userMapper.findUserByUserId(user1);
        } catch (Exception e) {
            throw new SettingException("获取用户失败",null);
        }
        return user;
    }

    @Override
    public String uploadAvatar(MultipartFile file, Integer userId) {
        String destFile = null;
        String uuid = null;
        try {
            User user = userMapper.findUserByUserIdParam(userId);
            String preAvatar = user.getHeadUrl();
            uuid = UUID.randomUUID().toString();
            destFile = ImageUtils.GetImageFilePath(uuid);
            //创建新的jpg
            File imageFile = new File(destFile);
            if (!imageFile.exists()) imageFile.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(imageFile);
            fileOutputStream.write(file.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            //更新headUrl
            User tempUser = new User();
            tempUser.setHeadUrl(uuid);
            tempUser.setId(new Long(userId));
            userMapper.updateUserByUserId(tempUser);
            deletePreAvatar(preAvatar);
        } catch (Exception e) {
            throw new SettingException("上传图片失败", destFile);
        }
        return uuid;
    }
    //删除以前的头像
    public void deletePreAvatar(String preAvatar) throws Exception {
        if (preAvatar.equals("default")) return;
        ImageUtils.deleteImageFile(preAvatar);
    }

    @Override
    public Integer updateUserByUserId(User user) {
        try {
            userMapper.updateUserByUserId(user);
        }catch (Exception e){
            throw new SettingException("更新失败",null);
        }
        return 1;
    }
}
