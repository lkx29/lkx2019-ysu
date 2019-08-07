package com.neuedu.service;

import com.neuedu.exception.MyException;
import com.neuedu.pojo.UserInfo;

import java.util.List;

public interface IManagerService {
    public List<UserInfo> findAll () throws MyException;
}
