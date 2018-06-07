package com.zjyouths.healthproject.ssmnew.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjyouths.healthproject.ssmnew.dao.AuthMapper;
import com.zjyouths.healthproject.ssmnew.po.Auth;
import com.zjyouths.healthproject.ssmnew.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/auth")
public class AuthController {

//    @Autowired   不是直接调用dao层   直接调用serviece层
//    private AuthMapper authMapper;

    @Autowired//自动注入
    private AuthService authService;

    //   /auth/toMain
    @RequestMapping("/toAuth")
    public String main(){
        return "auth";
    }

    @RequestMapping(value = "/getAllAuth",produces = "application/json;charset=UTF-8")
    @ResponseBody//加上这个就不是去找页面 直接返回字符串  讲过好几遍了
    public String getAuth(){
        //List<Auth> auths = authMapper.queryByDbid(-1);  不直接调用dao层
        List<Auth> auths = authService.queryAllAuth();
        System.out.println(JSON.toJSONString(auths));
        return JSON.toJSONString(auths);
    }

    @RequestMapping(value = "/update",produces = "application/json;charset=UTF-8")
    @ResponseBody      //   加上这个就不是去找页面 直接返回字符串  讲过好几遍了
    public String update(Auth auth){
        System.out.println("auth = "+auth);
        //auth = Auth{dbid=12, authName='编辑新闻',
        // authCode='', authURL='/news/edit4', type='2', parentId=10, order=2, valid='0', layer=2, children=null}
        //UPDATE auth set authName = #{authName}, authCode = #{authCode},authURL = #{authURL},type = #{type},parentId =
        // #{parentId},order = #{order},valid = #{valid},layer = #{layer} where  dbid = #{dbid}
        //sql报错  找了很久发现  order是关键字
        int i = authService.doUpdate(auth);
        JSONObject jsonObject = new JSONObject();
        if(i == 1){
            //更新成功
            jsonObject.put("msg",true);
        }else{
            //失败
            jsonObject.put("msg",false);
        }
        System.out.println(jsonObject.toJSONString());
        return jsonObject.toJSONString();
    }

/*

    //    @ResponseBody  的作用  相当于以前的HttpServletResponse
    public void update(HttpServletResponse response){
        //@ResponseBody  用了这个 这些都不用写了
        response.setContentType("application/json;charset=UTF-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.write("JSON字符串");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

*/

    @RequestMapping(value = "/add",produces = "application/json;charset=UTF-8")
    @ResponseBody      //   加上这个就不是去找页面 直接返回字符串  讲过好几遍了
    public String add(Auth auth){
        System.out.println("auth = "+auth);
        //auth = Auth{dbid=12, authName='编辑新闻',
        // authCode='', authURL='/news/edit4', type='2', parentId=10, order=2, valid='0', layer=2, children=null}
        //UPDATE auth set authName = #{authName}, authCode = #{authCode},authURL = #{authURL},type = #{type},parentId =
        // #{parentId},order = #{order},valid = #{valid},layer = #{layer} where  dbid = #{dbid}
        //sql报错  找了很久发现  order是关键字
        int i = authService.doAddAuth(auth);
        JSONObject jsonObject = new JSONObject();
        if(i == 1){
            //更新成功
            jsonObject.put("msg",true);
        }else{
            //失败
            jsonObject.put("msg",false);
        }
        System.out.println(jsonObject.toJSONString());
        return jsonObject.toJSONString();
    }



}
