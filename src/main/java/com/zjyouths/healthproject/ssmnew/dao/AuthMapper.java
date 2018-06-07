package com.zjyouths.healthproject.ssmnew.dao;

import com.zjyouths.healthproject.ssmnew.po.Auth;

import java.util.List;

public interface AuthMapper {

    public List<Auth> queryByDbid(Integer dbid);

    public int doUpdate(Auth auth);

    public int doAddAuth(Auth auth);


    /**
     *   通过角色id  查询该角色有哪些权限
     *
     * @param roleId
     * @return
     */
    public List<Integer> queryByRoleId(Integer roleId);

}
