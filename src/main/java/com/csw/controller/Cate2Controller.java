package com.csw.controller;

import com.csw.entity.Cate1;
import com.csw.entity.Cate2;
import com.csw.service.Cate1Service;
import com.csw.service.Cate2Service;
import com.csw.service.ListService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("cate2")
public class Cate2Controller {
    @Autowired
    private Cate1Service cate1Service;
    @Autowired
    private ListService listService;
    @Autowired
    private Cate2Service cate2Service;

    @RequestMapping("addcate2first")
    public String addcate2first(HttpServletRequest request) {
        List<Cate1> cate1s = cate1Service.queryAll();
        for (Cate1 cate1 : cate1s) {
            System.out.println("cate1;;" + cate1);
        }
        request.setAttribute("cate1s", cate1s);
        return "back/addcate2";
    }

    @RequestMapping("add")
    public String add(Cate2 cate2, HttpServletRequest request) {
        cate2.setId(UUID.randomUUID().toString());
        System.out.println("cate2;;" + cate2);
        cate2Service.add(cate2);
        return "redirect:/list/queryAll";

    }

    @RequestMapping("findName")
    public String queryAll(String name, HttpServletResponse response) throws IOException {
        System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFname;;" + name);
        /**
         * 通过班级名字模糊查询
         */
        List<Cate1> caixiList = cate1Service.queryAllByName(name);
        for (Cate1 caixi : caixiList) {
            System.out.println("caixi;;" + caixi);
        }
        Gson gson = new Gson();
        String sss = gson.toJson(caixiList);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(sss);
        return null;
    }

    @RequestMapping("findCity")
    public String findCity(String parentId, HttpServletResponse response) throws IOException {
        System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
        /**
         * id是班级id
         */
        List<Cate2> caipuList = cate2Service.findBy(parentId);
        // 将cities转换成json字符串
        Gson gson = new Gson();
        String json = gson.toJson(caipuList);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        return null;
    }
}
