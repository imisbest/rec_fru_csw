package com.csw.controller;

import com.csw.entity.Admin;
import com.csw.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    public String login(Admin admin) {
        Admin aa = adminService.queryByNameAndPassword(admin.getName(), admin.getPassword());
        if (aa != null) {
            return "redirect:/list/queryAll";
        } else {
            return "back/login";
        }
    }
}
