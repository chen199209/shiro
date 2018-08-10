package com.dome.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/index")
public class TestController {

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(String userName, String password, Model model){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try{
            subject.login(token);
        }catch (UnknownAccountException e){
            e.printStackTrace();
            model.addAttribute("userName", "用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            model.addAttribute("password", "密码错误");
            return "login";
        }
        return "index";
    }

    @RequiresPermissions("user:add")
    @RequestMapping("/add")
    public String add(HttpServletRequest request){
        return "add";
    }


    @RequestMapping("/adds")
    public ModelAndView add(){
        return new ModelAndView("add");
    }
}
