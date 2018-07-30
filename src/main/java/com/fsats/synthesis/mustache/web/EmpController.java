package com.fsats.synthesis.mustache.web;

import com.fsats.synthesis.mustache.entity.Emp;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 员工Controller
 */
@Controller
@RequestMapping("/emp")
public class EmpController {


    @RequestMapping(value = {"list", ""})
    public String list(Model model) {
        List<Emp> empList = generateEmpList();
        model.addAttribute("empList", new Gson().toJson(empList));
        return "mustache/mustache";
    }

    @RequestMapping(value = "table")
    public String table(){
        return "bst/bstable";
    }

    public static List<Emp> generateEmpList() {
        List<Emp> empList = Lists.newArrayList();
        Emp emp1 = new Emp("1", "陈晓明","male","北京丰台","5000");
        Emp emp2 = new Emp("2", "王小二","male","北京丰台","4000");
        Emp emp3 = new Emp("3", "马小跳","male","北京丰台","4500");
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        return empList;
    }
}
