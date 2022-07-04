package cn.leolam.www.user.web.mapper;

import cn.leolam.www.user.web.entities.Notice;

import java.util.List;

public interface NoticeMapper {
    List<Notice> getNotices();
    List<Notice> getNoticeByPage(Integer page,Integer pageSize);
    Integer getNoticesCount();
    Integer insertNoticeByNotice(Notice notice);
    Integer deleteNoticeById(Integer id);
    Integer updateNoticeByNotice(Notice notice);
}
