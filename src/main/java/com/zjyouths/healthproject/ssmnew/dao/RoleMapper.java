package com.zjyouths.healthproject.ssmnew.dao;
import com.zjyouths.healthproject.ssmnew.po.Role;
import java.util.List;
import java.util.Map;

public interface RoleMapper {

    //这个是多条件查询  写成map      用这个Role类不好   会有2个属性一直是null  新增连个属性  page和rows
    public List<Role> query(Map<String ,Object> param);

    //获取多条件查询情况下   查询记录的总条数
    // 这个是查询 条件下所有的条数  不是当页的条数   返回该条件下的totalCount
    public int getCount(Map<String ,Object> param);


    public int add( Role role);

    public List<Map<String,Object>> getAllVilidAuth(Integer dbid );





    //先删除角色原来的权限    在新增这个角色的权限
    public int deleteByRoleId(Integer roleId);

    //这样写是没有问题的  但是对于mybatis  多参数是不太好的   能用一个参数就用一个参数
    //public int insertAuth(Integer roleId , Integer[] authIds);
    //List<Map<Integer,Integer>>    第一个是roleId   第二个是authId
    public int insertAuth(List<Map<String,Integer>> params);

}
