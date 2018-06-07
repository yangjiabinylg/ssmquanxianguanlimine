package com.zjyouths.healthproject.ssmnew.service;

import java.util.List;
import java.util.Map;

public interface RoleService {

    //total:38
    //List<Role>
    public  Map<String ,Object>  queryRole(Map<String ,Object> param);

    public List<Map<String,Object>> getAllVilidAuth(Integer roleId  );

    public int grantAuth(Integer roleId,Integer[] authIds);


}
