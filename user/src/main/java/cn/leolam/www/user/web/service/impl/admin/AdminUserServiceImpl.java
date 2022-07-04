package cn.leolam.www.user.web.service.impl.admin;

import cn.leolam.www.user.exception.admin.UserException;
import cn.leolam.www.user.properties.SecurityProperties;
import cn.leolam.www.user.web.entities.User;
import cn.leolam.www.user.web.mapper.*;
import cn.leolam.www.user.web.service.admin.AdminUserService;
import cn.leolam.www.user.web.utils.RestTemplateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@Transactional
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    SecurityProperties securityProperties;
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    AttentionMapper attentionMapper;

    @Autowired
    MessageMapper messageMapper;

    @Autowired
    ReplyMapper replyMapper;

    @Autowired
    RestTemplateUtils restTemplateUtils;

    @Override
    public List<User> getUsers(Integer page) {
        List<User> userList = null;
        try {
            if (page == 0) page = 1;
            Integer pageSize = securityProperties.getUserPageSize();
            int start = (page - 1) * pageSize;
            userList = userMapper.getUsersByPage(start, pageSize);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new UserException("获取用户信息失败");
        }
        return userList;
    }

    public Integer getUsersCount() {
        Integer res = null;
        try {
            res = userMapper.getUsersCount();
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new UserException("获取用户总数失败");
        }
        return res;
    }

    @Override
    public Integer insertUser(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userMapper.insertUserByUser(user);
            Long id = userMapper.getLastUserId();
            sysUserMapper.insertSysUserByEmailAndPassWordAndUsersId(id,user.getPassword(),user.getEmail());
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new UserException("新增用户失败");
        }
        return 1;
    }
    public Integer deleteUser(Long id, HttpServletRequest request){
        try {
            User user = userMapper.findUserByUserIdParam(Integer.parseInt(String.valueOf(id)));
            attentionMapper.deleteAttentionsByUserIdOrFans(id);
            messageMapper.deleteMessagesByYouOrUser(id);
            replyMapper.deleteReplysByFromOrTo(id);
            commentMapper.deleteCommentsByAuthor(id);
            sysUserMapper.deleteUserByEmail(user.getEmail());
            userMapper.deleteUserById(user.getId());
            HttpHeaders headers = new HttpHeaders();
            MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
            params.add("userId", String.valueOf(String.valueOf(id)));
            headers.add("Authorization", request.getHeader("Authorization"));
            ResponseEntity<Map> responseEntity = restTemplateUtils.sendToAuthGetUserToken("/video/admin/user/deleteUser",headers,params);
            Map<String, Object> map = responseEntity.getBody();
            if(!((Integer)map.get("code")==200)){
                throw new Exception();
            }
        }catch (Exception e){
            log.info(e.getMessage());
            throw new UserException("删除一名用户失败");
        }
        return 1;
    }

    @Override
    public Integer updateUser(User user) {
        try {
            if(user.getPassword() != null){
                user.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            userMapper.updateUserByUserId(user);
            sysUserMapper.updatePassWordEmailByUsersId(user.getId(),user.getPassword(),user.getEmail());
        }catch (Exception e){
            log.info(e.getMessage());
            throw new UserException("更新用户信息失败");
        }
        return 1;
    }
}
