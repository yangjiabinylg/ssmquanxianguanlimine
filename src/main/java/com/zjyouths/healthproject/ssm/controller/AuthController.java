package com.zjyouths.healthproject.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    //   /auth/toMain
    @RequestMapping("/toMain")
    public String main(){

        return "auth";
    }


}
