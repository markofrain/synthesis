package com.fsats.synthesis.ztree;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/treedata")
public class AreaTreeController {

    @Autowired
    private AreaTreeService areaTreeService;


    @RequestMapping("list")
    public String treeData(Model model){
        model.addAttribute("data", new Gson().toJson(areaTreeService.findAll()));
        return "ztree/ztree";
    }
}
