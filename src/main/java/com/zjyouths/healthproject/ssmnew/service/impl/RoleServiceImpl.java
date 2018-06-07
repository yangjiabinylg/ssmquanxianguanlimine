package com.zjyouths.healthproject.ssmnew.service.impl;

import com.zjyouths.healthproject.ssmnew.dao.AuthMapper;
import com.zjyouths.healthproject.ssmnew.dao.RoleMapper;
import com.zjyouths.healthproject.ssmnew.po.Role;
import com.zjyouths.healthproject.ssmnew.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AuthMapper authMapper;

    @Override
    public Map<String, Object> queryRole(Map<String, Object> param) {
        int count = roleMapper.getCount(param);
        List<Role> roleList = roleMapper.query(param);
        HashMap<String ,Object> map = new HashMap<>();
        map.put("total",count);
        map.put("rows",roleList);


        return map;
    }

    @Override
    public List<Map<String, Object>> getAllVilidAuth(Integer roleId ) {
        System.out.println("roleId= "+roleId);
        //查询所有有效的权限
        List<Map<String, Object>> validAuth = roleMapper.getAllVilidAuth(-1);
        //当前角色有的权限
        List<Integer> auths = authMapper.queryByRoleId(roleId);

        System.out.println(auths);
        //递归解析
        parseAuth(validAuth,auths);

        System.out.println(auths);
        System.out.println(validAuth);

        return validAuth;
    }

    @Override
    public int grantAuth(Integer roleId, Integer[] authIds) {

        int i = roleMapper.deleteByRoleId(roleId);
        System.out.println("删除  "+i);
        List<Map<String,Integer>> param = new ArrayList<>();
        for(Integer authId : authIds){
            Map<String,Integer> map = new HashMap<>();
            map.put("roleId",roleId);
            map.put("authId",authId);
            param.add(map);
        }
        int j = roleMapper.insertAuth(param);
        System.out.println("新增 "+j);

        return i+j;
    }

    /**'
     *    递归调用  children
     */
    private void parseAuth(List<Map<String, Object>> validAuth ,List<Integer> auths){

        for(Map<String,Object> auth : validAuth){
            //获取当前遍历的权限id
            Integer id = (Integer) auth.get("id");
            if(auths.contains(id)){
                auth.put("checked",true);
            }
            List<Map<String, Object>> children = (List<Map<String, Object>>) auth.get("children");
            parseAuth(children,auths);
        }

    }








}
