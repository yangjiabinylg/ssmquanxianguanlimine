package com.zjyouths.healthproject.ssmnew.dao;

import com.alibaba.fastjson.JSON;
import com.zjyouths.healthproject.ssmnew.po.Role;
import com.zjyouths.healthproject.ssmnew.service.RoleService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class RoleMapperTest {
    @Test
    public void queryService() {
        //交给spring管理了
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleService roleService = (RoleService) ctx.getBean(RoleService.class);
        Map<String,Object> param = new HashMap<>();
        // param.put("roleName","管理员");
        //param.put("valid","1");
        int page = 2;//第2页
        int rows = 2;//每页显示2行
        param.put("roleName","1");
        param.put("start",(page-1)*rows);
        param.put("rows",rows);
        Map<String ,Object> query = (Map<String ,Object>) roleService.queryRole(param);

        System.out.println(query);

        System.out.println(JSON.toJSONString(query));

    }

    @Test
    public void query() {
        //交给spring管理了
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleMapper roleMapper = ctx.getBean(RoleMapper.class);
        Map<String,Object> param = new HashMap<>();
       // param.put("roleName","管理员");
        //param.put("valid","1");
        int page = 2;//第2页
        int rows = 2;//每页显示2行
        param.put("roleName","1");
        param.put("start",(page-1)*rows);
        param.put("rows",rows);
        List<Role> query = roleMapper.query(param);

        System.out.println(query.size());
        int queryCount = roleMapper.getCount(param);
        System.out.println(queryCount);

        System.out.println(JSON.toJSONString(query));

    }

    @Test
    public void queryCount() {
        //交给spring管理了
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleMapper roleMapper = ctx.getBean(RoleMapper.class);
        Map<String,Object> param = new HashMap<>();
        //param.put("roleName","管理员");
        //param.put("valid","1");
        param.put("roleName","1");
        int page = 2;//第2页
        int rows = 2;//每页显示2行

        param.put("start",(page-1)*rows);
        param.put("rows",rows);
        int query = roleMapper.getCount(param);

        System.out.println(query);
        System.out.println(JSON.toJSONString(query));

    }


    @Test
    public void testRoleAdd() {
        //交给spring管理了
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleMapper roleMapper = ctx.getBean(RoleMapper.class);
        //List<Role> roleList = new ArrayList<>();
        for (int i = 6 ; i<100 ;i++){
            Role role = new Role();
            role.setOrders(i);
            role.setRoleCode("role"+i);
            role.setRoleName("角色"+i);
            role.setValid(String.valueOf(1));
            //roleList.add(int kk = roleMapper.add(param););
            int kk = roleMapper.add(role);
        }


    }
}