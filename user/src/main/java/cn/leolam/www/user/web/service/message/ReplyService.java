package cn.leolam.www.user.web.service.message;

import cn.leolam.www.user.web.entities.Message;

import java.util.List;

public interface ReplyService {
    List<Message> getMessages(Long userId);
    public Integer deleteMessage(Long id);
}
