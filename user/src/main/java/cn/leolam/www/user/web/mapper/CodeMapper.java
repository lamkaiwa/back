package cn.leolam.www.user.web.mapper;

import cn.leolam.www.user.web.entities.Code;

public interface CodeMapper {
    //删除一个code
    Integer deleteCodeByUserId(Code code);
    //插入一个code
    Integer insertCodeByUserIdAndCode(Code code);
    //根据userid查找Code
    Code findCodeByUserId(Long id);

}
