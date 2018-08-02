package com.fsats.synthesis.excelImportserver.controller;

import com.fsats.synthesis.excelImportserver.entity.Student;
import com.fsats.synthesis.excelImportserver.util.ExcelUtil;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * 执行Excel控制类
 */
@Controller
@RequestMapping("/poi")
public class ExcelController {

    @RequestMapping("show")
    public String show(){
        return "excelpoi/excels";
    }

    @RequestMapping("import")
    public String importFile(MultipartFile file) throws IOException{
        if(!file.isEmpty()){
            ExcelUtil excelUtil = new ExcelUtil(file.getOriginalFilename(),file.getInputStream());
            List<Student> studentList = null;
            try {
                studentList = excelUtil.getDataList();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            System.out.println(studentList);
        }
        return "excelpoi/excels";
    }

    @RequestMapping("export")
    @ResponseBody
    public void exportFile(HttpServletResponse response){

        //设置一个对象作为数据
        String fileName = "学生数据";
        List<Student> studentList = Lists.newArrayList();
        studentList.add(new Student("1","张小小","女","20","北京丰台","165"));
        //写文件
        ExcelUtil excelUtil = new ExcelUtil();
        try {
            excelUtil.exportTemplate(response,fileName,studentList,5);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
