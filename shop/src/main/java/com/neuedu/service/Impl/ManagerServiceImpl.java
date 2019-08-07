package com.neuedu.service.Impl;

import com.neuedu.dao.UserInfoMapper;
import com.neuedu.exception.MyException;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManagerServiceImpl implements IManagerService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> findAll() throws MyException {
        return userInfoMapper.selectAll();
    }
}
