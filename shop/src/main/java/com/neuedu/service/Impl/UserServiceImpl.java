package com.neuedu.service.Impl;

import com.neuedu.dao.UserInfoMapper;
import com.neuedu.exception.MyException;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserInfoMapper userInfoMapper;
    @Override
    public UserInfo login(UserInfo userInfo) throws MyException {
        //step1:参数非空校验
        if (userInfo==null){
            throw  new MyException("参数不能为空1111");
        }
        if (userInfo==null||userInfo.getUsername()==null||userInfo.getUsername().equals("")){
            throw  new MyException("用户名不能为空2222");
        }
        if (userInfo.getPassword()==null||userInfo.getPassword().equals("")){
            throw new MyException("密码不能为空3333");
        }
        //step2:判断用户名是否存在
        int username_result =userInfoMapper.exsitsUsername(userInfo.getUsername());
        if (username_result == 0) {
            throw new MyException("用户名不存在！4444");
        }
        //step3:根据用户名和密码登录
        //UserInfo userInfo_result=userInfoMapper.findByUsernameAndPassword(userInfo);
        UserInfo userInfo_result=userInfoMapper.findByUsernameAndPassword
                (userInfo.getUsername(), userInfo.getPassword());
        if (userInfo_result==null){
            throw  new MyException("密码错误5555");
        }
        //step4:判断权限
        if (userInfo_result.getRole()!=0){//不是一个管理员
            throw new MyException("没有权限访问6666");
        }
        System.out.println("===================service正确===============");
        return userInfo_result;
    }

    @Override
    public UserInfo findByUsername(String username) throws MyException{
      UserInfo userInfo=userInfoMapper.findByUsername(username);

        return userInfo;
    }

    @Override
    public List<UserInfo> findAll() throws MyException {

        List<UserInfo> userInfos=userInfoMapper.selectAll();
        return userInfos;
    }

    @Override
    public UserInfo findById(int userInfoId) throws MyException {
        return userInfoMapper.selectByPrimaryKey(userInfoId);
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) throws MyException {
        return userInfoMapper.updateByPrimaryKey(userInfo);
    }

    @Override
    public int addUserInfo(UserInfo userInfo) throws MyException {
        return userInfoMapper.insert(userInfo);
    }

    @Override
    public int deleteUserInfo(int userInfoId) throws MyException {
        return userInfoMapper.deleteByPrimaryKey(userInfoId);
    }


}
