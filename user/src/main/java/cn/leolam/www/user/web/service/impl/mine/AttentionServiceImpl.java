package cn.leolam.www.user.web.service.impl.mine;

import cn.leolam.www.user.exception.mine.AttentionException;
import cn.leolam.www.user.web.entities.Attention;
import cn.leolam.www.user.web.entities.User;
import cn.leolam.www.user.web.mapper.AttentionMapper;
import cn.leolam.www.user.web.mapper.UserMapper;
import cn.leolam.www.user.web.service.mine.AttentionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class AttentionServiceImpl implements AttentionService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    AttentionMapper attentionMapper;

    @Override
    public List<User> getAttentionUser(User user) {
        List<User> userList = null;
        try {
            userList = userMapper.getUsersByUserIdThroughAttention(user);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new AttentionException("获取列表失败");
        }
        return userList;
    }

    @Override
    public boolean updateAttention(Attention attention) {
        try {
            User user = new User();
            user.setId(attention.getUserId());
            user.setFansCount(new Long(-1));
            if (userMapper.updateUserByUserId(user) + attentionMapper.deleteAttentionByUserIdAndFans(attention) != 2) {
                throw new AttentionException("更新失败");
            }
        } catch (Exception e) {
            throw new AttentionException(e.getMessage());
        }
        return true;
    }
}
