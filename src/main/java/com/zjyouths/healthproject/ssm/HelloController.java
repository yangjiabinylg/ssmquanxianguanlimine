package com.zjyouths.healthproject.ssm;

import com.alibaba.fastjson.JSON;
import com.zjyouths.healthproject.ssm.dao.OrderMapper;
import com.zjyouths.healthproject.ssm.po.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @Autowired
    private OrderMapper orderMapper;


    /**
     *     测试controller注解      ss好了没   spring和spring-mvc
     */
    @RequestMapping("/hello")
    public String hello(){
        UserOrder userOrder = orderMapper.queryByUid(1);
        System.out.println(JSON.toJSONString(userOrder));//能输入则mybatis好了

        return "success";//能成功跳转就ss没问题了
    }


}
