package cn.leolam.www.user.web.service.admin;

import cn.leolam.www.user.web.entities.Notice;

import java.util.List;

public interface AdminNoticeService {
    List<Notice> getNoticeByPage(Integer page);
    Integer getNoticesCount();
    Integer insertNoticeByNotice(Notice notice);
    Integer deleteNoticeById(Integer id);
    Integer updateNoticeByNotice(Notice notice);
}
