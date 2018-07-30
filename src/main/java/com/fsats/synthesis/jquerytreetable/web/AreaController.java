package com.fsats.synthesis.jquerytreetable.web;

import com.fsats.synthesis.common.CommonUtil;
import com.fsats.synthesis.jquerytreetable.entity.Area;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/area")
public class AreaController {


    @RequestMapping("list")
    public String list(Model model){
        List<Area> areaList = CommonUtil.areaList;
        model.addAttribute("areaList",new Gson().toJson(areaList));
        return "bst/bstable";
    }
}
