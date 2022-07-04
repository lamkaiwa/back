package cn.leolam.www.user.web.service.user;

import cn.leolam.www.user.web.entities.Attention;
import cn.leolam.www.user.web.entities.Video;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    /**
     * 是否已经关注了
     * @param attention
     * @return
     */
    Boolean isAttention(Attention attention);

    /**
     * 取消关注
     * @param attention
     */
    void cancelAttention(Attention attention);

    /**
     * 添加关注
     * @param attention
     */
    void addAttention(Attention attention);

    /**
     * 根据字符，SortType 和 page 来获取video信息
     * @param page
     * @param words
     * @param sortBy
     * @param userId
     * @param request
     * @return
     */
    List<Video> getSearchVideoByLikeSortTypeUserId(Integer page, String words, String sortBy, Integer userId, HttpServletRequest request);

    /**
     * 根据words userid 获取一共有多少个视频
     * @param words
     * @param userId
     * @param request
     * @return
     */
    Integer getSearchVideoCountByLikeUserId(String words, Integer userId,HttpServletRequest request);
}
