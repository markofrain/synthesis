package com.fsats.synthesis.twbs_pagination;

import com.fsats.synthesis.ztree.AreaTree;
import com.fsats.synthesis.ztree.AreaTreeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pagination")
public class PageController {

    @Autowired
    private AreaTreeService areaTreeService;

    @RequestMapping("list")
    public String list(Model model, @RequestParam(defaultValue = "1") Integer pageNum){
        //model.addAttribute("data", areaTreeService.findAll());
        PageInfo<AreaTree> pageInfo = areaTreeService.pageList(pageNum, 15);
        model.addAttribute("pageInfo", pageInfo);
        return "pagination/page";
    }

}
