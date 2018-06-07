package com.zjyouths.healthproject.ssmnew.service;

import com.zjyouths.healthproject.ssmnew.po.Auth;

import java.util.List;

public interface AuthService {



    public List<Auth> queryAllAuth( );

    public int doUpdate(Auth auth);


    public int doAddAuth(Auth auth);



}
