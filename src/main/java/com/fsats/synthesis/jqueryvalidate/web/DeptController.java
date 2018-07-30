package com.fsats.synthesis.jqueryvalidate.web;

import com.fsats.synthesis.jqueryvalidate.entity.Dept;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 部门Controller
 */
@Controller
@RequestMapping("/dept")
public class DeptController {


    @RequestMapping("form")
    public String form(Model model){
        model.addAttribute("dept",new Dept());
        return "jvalidate/deptForm";
    }

    @RequestMapping("save")
    public String save(Dept dept,Model model){
        System.out.println(dept);
        model.addAttribute("dept",dept);
        return "jvalidate/list";
    }

    @RequestMapping("remote")
    @ResponseBody
    public String remote(String name){
        System.out.println(name);
        if(name.equals("name")){
            return new Gson().toJson("true");
        }
        return new Gson().toJson("false");
    }
}
