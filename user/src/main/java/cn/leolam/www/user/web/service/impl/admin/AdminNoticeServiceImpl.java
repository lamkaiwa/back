package cn.leolam.www.user.web.service.impl.admin;

import cn.leolam.www.user.exception.admin.AdminNoticeException;
import cn.leolam.www.user.properties.SecurityProperties;
import cn.leolam.www.user.web.entities.Message;
import cn.leolam.www.user.web.entities.Notice;
import cn.leolam.www.user.web.mapper.MessageMapper;
import cn.leolam.www.user.web.mapper.NoticeMapper;
import cn.leolam.www.user.web.service.admin.AdminNoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class AdminNoticeServiceImpl implements AdminNoticeService {
    @Autowired
    NoticeMapper noticeMapper;

    @Autowired
    SecurityProperties securityProperties;

    @Override
    public List<Notice> getNoticeByPage(Integer page) {
        List<Notice> noticeList = null;
        try {
            if (page == 0) page = 1;
            Integer pageSize = securityProperties.getPageSizeOnNoticePage();
            int start = (page - 1) * pageSize;
            noticeList = noticeMapper.getNoticeByPage(start, pageSize);
        }catch (Exception e){
            log.info(e.getMessage());
            throw new AdminNoticeException("获取通告失败");
        }
        return noticeList;
    }

    @Override
    public Integer getNoticesCount() {
        Integer res = null;
        try {
            res = noticeMapper.getNoticesCount();
        }catch (Exception e){
            log.info(e.getMessage());
            throw new AdminNoticeException("获取通告数量失败");
        }
        return res;
    }

    @Override
    public Integer insertNoticeByNotice(Notice notice) {
        try {
            noticeMapper.insertNoticeByNotice(notice);
        }catch (Exception e){
            log.info(e.getMessage());
            throw new AdminNoticeException("新增通告失败");
        }
        return 1;
    }

    @Override
    public Integer deleteNoticeById(Integer id) {
        try {
            noticeMapper.deleteNoticeById(id);
        }catch (Exception e){
            log.info(e.getMessage());
            throw new AdminNoticeException("删除通告失败");
        }
        return 1;
    }

    @Override
    public Integer updateNoticeByNotice(Notice notice) {
        try {
            noticeMapper.updateNoticeByNotice(notice);
        }catch (Exception e){
            log.info(e.getMessage());
            throw new AdminNoticeException("更新通知失败");
        }
        return 1;
    }
}
