package com.kuizhi.core.controller;

import com.kuizhi.core.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @Author 甘肃跬智学院 吴宗运
 * @date 2020/4/1 0001 14:47
 */
@Controller
public class TestController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "login.html";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(String username, String password, HttpServletRequest request, HttpServletResponse response, HttpSession session){
        User user = new User();
        user.setUserName(username);
        user.setPassWord(password);
        session.setAttribute("user",user);
        return "ok";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(HttpServletRequest request){
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("user");
        request.setAttribute("user", user);
        return "HomePage.html";
    }
}
