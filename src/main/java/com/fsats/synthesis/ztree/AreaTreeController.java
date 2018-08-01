package com.fsats.synthesis.ztree;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    @RequestMapping("get")
    @ResponseBody
    public String get(Integer id, HttpServletResponse response){
        response.setContentType("application/json;charset=UTF-8");
        //List<AreaTree> areaTreeList = areaTreeService.get(id==null?0:id);
        List<TestArea> testAreaTreeList = areaTreeService.getTestArea(id==null?0:id);
        return new Gson().toJson(testAreaTreeList);
    }

    @RequestMapping("root")
    public String getRoot(Model model){
        List<AreaTree> areaTreeList = areaTreeService.getRoot();
        model.addAttribute("data", new Gson().toJson(areaTreeList));
        return "ztree/asyncTree";
    }
}
