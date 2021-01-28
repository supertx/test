package com.qinli.controller;

import com.qinli.pojo.LoginValue;
import com.qinli.pojo.User;
import com.qinli.service.ILoginService;
import com.qinli.util.JWTUtils;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author supermantx
 * @time 2021/1/25 12:11
 * 登陆部分的控制器
 * 半年没碰java后的杰作(啥也不是)
 */

@Controller
@RequestMapping("/EduReformProjectQuerySys")
public class LoginController {

    @Autowired
    ILoginService loginService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginValue loginJud(@RequestHeader("Content-Type")String ct, String username, String pwd){
        LoginValue lv = new LoginValue();
        User user = new User(username, pwd);
        if (ct.equals("application/x-www-form-urlencoded")){
            if(loginService.findUser(username)){
                if (loginService.judge(username, pwd)){
                    lv.setStaCode(200);
                    lv.setToken(JWTUtils.getToken(user));
                }else{
                    lv.setStaCode(500);
                }
            }else{
                lv.setStaCode(400);
            }
        }else{
            lv.setStaCode(500);
        }
        lv.setUser(user);
        return lv;
    }
}
