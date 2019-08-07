package com.neuedu.service;

import com.neuedu.exception.MyException;
import com.neuedu.pojo.UserInfo;
import org.mybatis.spring.MyBatisExceptionTranslator;

public interface IUserService {
    public UserInfo login(UserInfo userInfo)throws MyException;
    public UserInfo findByUsername(String username) ;
}
