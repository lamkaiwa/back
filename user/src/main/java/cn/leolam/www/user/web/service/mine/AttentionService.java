package cn.leolam.www.user.web.service.mine;

import cn.leolam.www.user.web.entities.Attention;
import cn.leolam.www.user.web.entities.User;

import java.util.List;

public interface AttentionService {
    /**
     * 获取关注列表
     * @param user
     * @return
     */
    List<User> getAttentionUser(User user);

    /**
     * 取消关注
     * @param attention
     * @return
     */
    boolean updateAttention(Attention attention);
}
