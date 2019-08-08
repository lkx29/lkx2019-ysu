package com.neuedu.service;

import com.neuedu.exception.MyException;
import com.neuedu.pojo.Category;
import com.neuedu.pojo.UserInfo;
import org.mybatis.spring.MyBatisExceptionTranslator;

import java.util.List;

public interface IUserService {
    public UserInfo login(UserInfo userInfo)throws MyException;
    public UserInfo findByUsername(String username) throws MyException;
    public List<UserInfo> findAll()throws MyException;
    public UserInfo findById(int userInfoId)throws  MyException;
    public int updateUserInfo(UserInfo userInfo)throws MyException;
    public int addUserInfo(UserInfo userInfo)throws MyException;
    public int deleteUserInfo(int userInfoId)throws  MyException;
}
