package com.fsats.synthesis.jbox;

import com.fsats.synthesis.ztree.AreaTree;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/jbox")
public class JboxController {

    @RequestMapping("index")
    public String index(){
        return "jbox/index";
    }

    /**
     * 测试弹框页面提交，模拟保存
     * @return
     */
    @ResponseBody
    @RequestMapping("save")
    public String save(Model model,AreaTree areaTree){
        System.out.println(areaTree);
        model.addAttribute("data", areaTree);
        return "jbox/show";
    }

    /**
     * 模拟ajax弹框请求
     * @return
     */
    @ResponseBody
    @RequestMapping("get")
    public String get(Integer id) throws InterruptedException {
        AreaTree areaTree = new AreaTree();
        areaTree.setId(1);
        areaTree.setName("北京");
        areaTree.setPid(0);
        Thread.sleep(5000);
        return new Gson().toJson(areaTree);
    }
}
