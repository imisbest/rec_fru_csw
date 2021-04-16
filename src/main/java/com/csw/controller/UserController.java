package com.csw.controller;

import com.csw.entity.User;
import com.csw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("login")
    public String login(User user, HttpServletRequest request) {
        User aa = userService.queryByNameAndPassword(user.getName(), user.getPassword());
        if (aa != null) {
            System.out.println("aa;;"+aa);
            request.getSession().setAttribute("user",aa);
            return "redirect:/list/query0";
        } else {
            return "front/login";
        }
    }
}
