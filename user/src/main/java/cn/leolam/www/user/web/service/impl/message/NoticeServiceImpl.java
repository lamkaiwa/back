package cn.leolam.www.user.web.service.impl.message;

import cn.leolam.www.user.exception.message.NoticeException;
import cn.leolam.www.user.web.entities.Notice;
import cn.leolam.www.user.web.mapper.NoticeMapper;
import cn.leolam.www.user.web.service.message.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Slf4j
@Transactional
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeMapper noticeMapper;
    @Override
    public List<Notice> getNotices() {
        List<Notice> noticeList = null;
        try {
            noticeList = noticeMapper.getNotices();
        }catch (Exception e){
            log.info(e.getMessage());
            throw new NoticeException("获取系统消息错误");
        }
        return noticeList;
    }
}
