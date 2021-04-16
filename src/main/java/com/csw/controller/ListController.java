package com.csw.controller;

import com.csw.entity.Cate2;
import com.csw.entity.Lis;
import com.csw.entity.Rec;
import com.csw.entity.User;
import com.csw.service.Cate2Service;
import com.csw.service.ListService;
import com.csw.service.RecService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("list")
public class ListController {
    @Autowired
    private ListService listService;
    @Autowired
    private Cate2Service cate2Service;
    @Autowired
    private RecService recService;

    @RequestMapping("queryAll")
    public String queryAll(HttpServletRequest request) {
        /**
         * 查询所有水果
         */
        List<Lis> listLis = listService.queryAll();
        for (Lis listLi : listLis) {
            System.out.println("queryAll-lists;;" + listLi);
        }
        request.setAttribute("listLis", listLis);
        /**
         * 查询所有类别
         */
        List<Cate2> cate2s = cate2Service.queryAll();
        for (Cate2 cate2 : cate2s) {
            System.out.println("cate2;;" + cate2);
        }
        request.setAttribute("cate2s", cate2s);
        /**
         *
         */
        return "back/list";
    }

    @RequestMapping("add")
    public String add(Lis lis, String pid, MultipartFile bb, HttpServletRequest request) throws IOException {
        lis.setId(UUID.randomUUID().toString());
        lis.setCount(0);
        Cate2 c2 = cate2Service.queryByid(pid);
        System.out.println("c2;;" + c2);
        lis.setCategory(c2.getName());
        /**
         *
         */
        if (bb.getOriginalFilename().equals("")) {
            return "redirect:/back/add.jsp";
        }
        System.out.println("文件名//：" + bb.getOriginalFilename());
        System.out.println("文件类型//:" + bb.getContentType());
        System.out.println("文件大小//:" + bb.getSize());
        System.out.println("name//:" + bb.getName());
        // System.out.println("后缀//:" + bb.getOriginalFilename().substring(bb.getOriginalFilename().lastIndexOf(".")));
        String realPath = request.getSession().getServletContext().getRealPath("/upDown");
        System.out.println("realPath//:" + realPath);
        String newFileNamePrefix = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
                + UUID.randomUUID().toString().replace("-", "");
        String fileNameSuffix = "." + FilenameUtils.getExtension(bb.getOriginalFilename());
        String newFileName = newFileNamePrefix + fileNameSuffix;
        String dateDirString = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        System.out.println("dateDirString//:" + dateDirString);
        File dateDir = new File(realPath, dateDirString);
        System.out.println("dateDir//:" + dateDir);
        if (!dateDir.exists()) {
            dateDir.mkdirs();
        }
        bb.transferTo(new File(dateDir, newFileName));
        String id = UUID.randomUUID() + "";
        String oname = bb.getOriginalFilename();
        String nname = newFileName;
        String z_file = oname.substring(oname.lastIndexOf("."));
        String path = dateDirString;
        System.out.println("path;;" + path);
        String sizes = bb.getSize() + "";
        String type = bb.getContentType();
        String istrue = bb.getOriginalFilename();
        String count = "0";
        // fileService.addFile(new File1(id, oname, nname, z_file, path, sizes, type, istrue, count));

        /**
         *
         */
        lis.setPic(bb.getOriginalFilename());
        lis.setPath(path);
        lis.setNname(nname);
        listService.add(lis);
        System.out.println("list;LLLLLLLLLLLLLLLLLLLLLLLLL;" + lis);
/**
 *
 */

        return "redirect:/list/queryAll";

    }

    @RequestMapping("updatefirst")
    public String updatefirst(String id, HttpServletRequest request) {
        System.out.println("id;;" + id);
        if (id == null) {
            id = (String) request.getSession().getAttribute("id");
        }
        /**
         * 查询所有水果
         */
        System.out.println("id2;;" + id);
        Lis lis = listService.queryAllByid(id);
        System.out.println("lis;;" + lis);
        request.setAttribute("lis", lis);
        /**
         * 查询所有类别
         */
        List<Cate2> cate2s = cate2Service.queryAll();
        for (Cate2 cate2 : cate2s) {
            System.out.println("cate2;;" + cate2);
        }
        request.setAttribute("cate2s", cate2s);
        /**
         *
         */
        return "back/update";
    }

    @RequestMapping("update")
    public String update(Lis lis, String pid, MultipartFile bb, HttpServletRequest request) throws IOException {
        System.out.println("lis;;" + lis);
        /**
         *
         */
        if (bb.getOriginalFilename().equals("")) {
            request.getSession().setAttribute("id", pid);
            return "redirect:/list/updatefirst";
        }
        /**
         *
         */
        /*   lis.setId(UUID.randomUUID().toString());*/
        lis.setCount(0);
        Cate2 c2 = cate2Service.queryByid(pid);
        System.out.println("c2;;" + c2);
        lis.setCategory(c2.getName());
        /**
         *
         */
        System.out.println("文件名//：" + bb.getOriginalFilename());
        System.out.println("文件类型//:" + bb.getContentType());
        System.out.println("文件大小//:" + bb.getSize());
        System.out.println("name//:" + bb.getName());
        // System.out.println("后缀//:" + bb.getOriginalFilename().substring(bb.getOriginalFilename().lastIndexOf(".")));
        String realPath = request.getSession().getServletContext().getRealPath("/upDown");
        System.out.println("realPath//:" + realPath);
        String newFileNamePrefix = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
                + UUID.randomUUID().toString().replace("-", "");
        String fileNameSuffix = "." + FilenameUtils.getExtension(bb.getOriginalFilename());
        String newFileName = newFileNamePrefix + fileNameSuffix;
        String dateDirString = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        System.out.println("dateDirString//:" + dateDirString);
        File dateDir = new File(realPath, dateDirString);
        System.out.println("dateDir//:" + dateDir);
        if (!dateDir.exists()) {
            dateDir.mkdirs();
        }
        bb.transferTo(new File(dateDir, newFileName));
        String id = UUID.randomUUID() + "";
        String oname = bb.getOriginalFilename();
        String nname = newFileName;
        String z_file = oname.substring(oname.lastIndexOf("."));
        String path = dateDirString;
        System.out.println("path;;" + path);
        String sizes = bb.getSize() + "";
        String type = bb.getContentType();
        String istrue = bb.getOriginalFilename();
        String count = "0";
        // fileService.addFile(new File1(id, oname, nname, z_file, path, sizes, type, istrue, count));

        /**
         *
         */
        lis.setPic(bb.getOriginalFilename());
        lis.setPath(path);
        lis.setNname(nname);
        System.out.println("oname;;" + oname);
        listService.updateLis(lis);
        System.out.println("list;LLLLLLLLLLLLLLLLLLLLLLLLL;" + lis);
/**
 *
 */

        return "redirect:/list/queryAll";
    }

    @RequestMapping("query0")
    public String query0(HttpServletRequest request) {

        User uu = (User) request.getSession().getAttribute("user");
        List<Lis> lis = listService.query0();

        request.setAttribute("lis", lis);
        return "/front/list";
    }

    @RequestMapping("query")
    public String query(String findall, HttpServletRequest request) {
        System.out.println("findall::" + findall);

        User uu = (User) request.getSession().getAttribute("user");
        List<Lis> lis = listService.query(findall);
        for (Lis li : lis) {
            Lis ll = listService.queryAllByid(li.getId());
            Rec rec = recService.queryByName(ll.getName(),uu.getId());
            if (rec == null) {
                recService.add(new Rec(UUID.randomUUID().toString(), ll.getName(), 1, uu.getId()));
            } else {
                rec.setCcc(rec.getCcc() + 1);
                System.out.println("rec;;" + rec);
                recService.update(rec);
            }
            System.out.println("lis;;" + li);
        }
        request.setAttribute("lis", lis);
        return "/front/list";
    }

    @RequestMapping("addCount")
    public String addCount(String find, HttpServletRequest request) {
        System.out.println("find;;" + find);
        User uu = (User) request.getSession().getAttribute("user");
        System.out.println("addCount uu;;"+uu);
        /**
         *
         */
        Rec rec = recService.queryByName(find,uu.getId());
        System.out.println("rec;;"+rec);
        Lis ln = listService.queryByName(find);
        if (rec == null) {
            System.out.println("1");
            recService.add(new Rec(UUID.randomUUID().toString(), ln.getName(), 1, uu.getId()));
        } else {
            System.out.println("2");
            rec.setCcc(rec.getCcc() + 1);
            recService.update(rec);
        }
        return null;
    }

    @RequestMapping("rec")
    @ResponseBody
    public List<Lis> rec(HttpServletRequest request) {
        User uu = (User) request.getSession().getAttribute("user");
        List<Lis> lisList = new ArrayList<>();
        if (uu == null) {
            return null;
        } else {
            List<Rec> recs = recService.queryByCCC(uu.getId());
            for (Rec rec : recs) {
                Lis ll = listService.queryByName(rec.getName());
                lisList.add(ll);
            }

            System.out.println("lisList;;" + lisList);
            return lisList;
        }
    }
}
