package com.zjyouths.healthproject.ssmnew.service.impl;

import com.zjyouths.healthproject.ssmnew.dao.AuthMapper;
import com.zjyouths.healthproject.ssmnew.po.Auth;
import com.zjyouths.healthproject.ssmnew.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("authService")//别忘了起个名字不写默认是  authServiceImpl   自己类名首字母小写
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthMapper authMapper;

    @Override
    public List<Auth> queryAllAuth( ) {
        return authMapper.queryByDbid(-1);
    }

    @Override
    public int doUpdate(Auth auth) {
        return authMapper.doUpdate(auth);
    }

    @Override
    public int doAddAuth(Auth auth) {
        return authMapper.doAddAuth(auth);
    }
}
