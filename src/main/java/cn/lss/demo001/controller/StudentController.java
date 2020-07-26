package cn.lss.demo001.controller;


import cn.lss.demo001.dao.StudentDao;
import cn.lss.demo001.dao.impl.StudentDaoImpl;
import cn.lss.demo001.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private StudentDaoImpl dao;

    @RequestMapping("/test.html")
    public String index(@RequestParam("page") Integer indexPage, Model model){
        int size = dao.count();
        int totalPage;
        int limit = 10;
        if(size % limit == 0){
            totalPage = size / limit;
        }else {
            totalPage = size / limit +1;
        }
        List<Student> students = dao.findStudentByLimit(indexPage, limit);
        model.addAttribute("title","hello world");
        model.addAttribute("students",students);
        model.addAttribute("indexPage",indexPage);
        model.addAttribute("totalPage",totalPage);
        return "index/index";
    }


    @RequestMapping("/update.html")
    public String createUpdateForm(@RequestParam("id") Integer id, Model model){
        Student student = dao.selectOne(id);
        model.addAttribute("action","update");
        model.addAttribute("title","更新");
        model.addAttribute("student",student);

        return "index/form";
    }

    @RequestMapping("/update")
    public String update(Student student){
        System.out.println(student);
        int num = dao.update(student);
        System.out.println("执行了update操作");
        return "redirect:test.html?page=1";
    }

    @RequestMapping("/delete")
    public String deleteById(@RequestParam("id") Integer id,Model model){
        System.out.println("id == " +id);
        int num = dao.delete(id);
        System.out.println("执行了update操作");
        return "redirect:test.html?page=1";
    }

    @RequestMapping("/detail.html")
    public String showDetails(@RequestParam("id") Integer id, Model model){
        System.out.println("执行了查看操作");
        System.out.println("id == " +id);
        Student student = dao.selectOne(id);
        model.addAttribute("student",student);
        return "index/detail";
    }

    @RequestMapping("/add.html")
    public String createAddForm(Model model){
        model.addAttribute("action","add");
        model.addAttribute("student",new Student());
        return "index/form";

    }

    @PostMapping("/add")
    public String addStudent(Student student){
        System.out.println("执行了添加操作");
        System.out.println(student);
        dao.insert(student);
        return "redirect:test.html?page=1";
    }

    @RequestMapping("/search")
    public String search(@Param("keyword") String keyword, Model model){
        List<Student> students = dao.search(keyword);
        if(students!=null){
            model.addAttribute("students",students);
        }else {
            model.addAttribute("students",new Student());
        }
        int totalPage;
        int limit = 10;
        int size = students.size();
        if(size % limit == 0){
            totalPage = size / limit;
        }else {
            totalPage = size / limit +1;
        }

        model.addAttribute("title","hello world");

        model.addAttribute("indexPage",1);
        model.addAttribute("totalPage",totalPage);


        return "index/index";
    }

}
