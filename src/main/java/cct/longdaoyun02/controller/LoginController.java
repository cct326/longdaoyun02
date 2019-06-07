package cct.longdaoyun02.controller;

import cct.longdaoyun02.model.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @PostMapping("/index")
    @ResponseBody
    public Result login(@RequestParam("username")String username,
                        @RequestParam("password")String password){
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, false);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return new Result(-1,"登录失败");
        }
        return new Result(0,"登录成功");
    }

    @GetMapping(value = {"/login","/"})
    public String loginURI(){
        return "/layui/login.html";
    }


}
