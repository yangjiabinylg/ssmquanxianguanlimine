package com.zjyouths.healthproject.ssmnew.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjyouths.healthproject.ssmnew.po.Auth;
import com.zjyouths.healthproject.ssmnew.service.AuthService;
import com.zjyouths.healthproject.ssmnew.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController {

//    @Autowired   不是直接调用dao层   直接调用serviece层
//    private AuthMapper authMapper;

    @Autowired//自动注入
    private RoleService roleService;

    //   /auth/toMain
    @RequestMapping("/toRole")
    public String main(){
        return "role";
    }


    @RequestMapping(value = "/queryRole",produces = "application/json;charset=UTF-8")
    @ResponseBody      //   加上这个就不是去找页面 直接返回字符串  讲过好几遍了
    public String add(String roleName,String roleCode,String valid,Integer page,Integer rows){

        Map<String ,Object> param = new HashMap<>();
        //如果前端没有填数据就会是个空字符串 这里我不喜欢在sql里面加 就这controller里面加了
        if("".equals(roleName)){
            roleName = null;
        }
        if("".equals(roleCode)){
            roleCode = null;
        }
        if("".equals(valid)){
            valid = null;
        }
        /**   阿里和spring这几个StringUtils这几个都一样的
             StringUtils.isEmpty(roleName) 方法通过返回布尔值说明是否为空
             这里的空包含null和空字符串
         */
        param.put("roleName", StringUtils.isEmpty(roleName) ? null : roleName);
        param.put("roleCode",roleCode);
        param.put("valid",valid);
        //param.put("page",page);
        param.put("start",(page - 1) * rows);
        param.put("rows",rows);
        System.out.println("param = "+param);
        Map<String, Object> map = roleService.queryRole(param);
        System.out.println(JSON.toJSONString(map));

        return JSON.toJSONString(map);


    }



    @RequestMapping(value = "/getAllVilidAuth",produces = "application/json;charset=UTF-8")
    @ResponseBody      //   加上这个就不是去找页面 直接返回字符串  讲过好几遍了
    public String getAllVilidAuth(Integer roleId){

        List<Map<String,Object>> map = (List<Map<String,Object>>) roleService.getAllVilidAuth( roleId);
        System.out.println(JSON.toJSONString(map));
        return JSON.toJSONString(map);

    }




    @RequestMapping(value = "/grantAuth",produces = "application/json;charset=UTF-8")
    @ResponseBody      //   加上这个就不是去找页面 直接返回字符串  讲过好几遍了
    public String grantAuth(Integer roleId,Integer[] authIds){
        System.out.println(roleId +"  "+authIds);
        System.out.println(roleId +"  "+ Arrays.toString(authIds));
        int i = roleService.grantAuth(roleId, authIds);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg",i>0);


        //return "";  这样不会走success   produces = "application/json;charset=UTF-8"  要求json
        return jsonObject.toJSONString();

    }
}
