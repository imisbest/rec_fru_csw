package com.csw.controller;

import com.csw.entity.Cate1;
import com.csw.service.Cate1Service;
import com.csw.service.Cate2Service;
import com.csw.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
@RequestMapping("cate1")
public class Cate1Controller {
    @Autowired
    private Cate1Service cate1Service;
    @Autowired
    private ListService listService;
    @Autowired
    private Cate2Service cate2Service;

    @RequestMapping("add")
    public String add(Cate1 cate1, HttpServletRequest request) {
        System.out.println("cate1.name;;" + cate1.getName());
        cate1.setId(UUID.randomUUID().toString());
        cate1Service.add(cate1);

        return "redirect:/list/queryAll";

    }

}
