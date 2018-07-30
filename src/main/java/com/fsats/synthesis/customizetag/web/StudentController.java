package com.fsats.synthesis.customizetag.web;

import com.alibaba.fastjson.JSON;
import com.fsats.synthesis.customizetag.entity.Student;
import com.fsats.synthesis.customizetag.util.GlobalUtil;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 学生Controller
 */
@Controller
@RequestMapping("/stu")
public class StudentController {

    @ModelAttribute("student")
    public Student get(String id){
        if(StringUtils.isNotBlank(id)){
            return null;
        }else{
            return new Student();
        }
    }
    @RequestMapping("index")
    public String index(Model model){
        model.addAttribute("student",GlobalUtil.getStudent(0));
        return "index";
    }

    @RequestMapping("get")
    @ResponseBody
    public String getStudent(String id){
        Student student = GlobalUtil.getStudent(id);
        System.out.println(student);
        return new Gson().toJson(student);
    }
}
