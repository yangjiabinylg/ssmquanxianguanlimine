package com.zjyouths.healthproject.ssmnew.dao;

import com.alibaba.fastjson.JSON;
import com.zjyouths.healthproject.ssmnew.po.Auth;
import com.zjyouths.healthproject.ssmnew.po.Role;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class AuthMapperTest {

    @Test
    public void queryByDbid() {
        //交给spring管理了
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        AuthMapper authMapper = ctx.getBean(AuthMapper.class);
        List<Auth> auths = authMapper.queryByDbid(-1);
        System.out.println(JSON.toJSONString(auths));
    }





}