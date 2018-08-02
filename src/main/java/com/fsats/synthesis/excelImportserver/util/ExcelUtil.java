package com.fsats.synthesis.excelImportserver.util;

import com.fsats.synthesis.excelImportserver.entity.Student;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 操作Excel工具类
 * 以Student类为例
 */
public class ExcelUtil {

    private InputStream is;     //文件输入流
    private String fileName;    //文件名
    private Workbook wb;        //wb对象

    public ExcelUtil() {
    }

    public ExcelUtil(String fileName, InputStream is) throws IOException {
        if(StringUtils.isBlank(fileName)){
            throw new RuntimeException("导入文档为空");
        }else if(fileName.toLowerCase().endsWith("xls")){
            this.wb = new HSSFWorkbook(is);
        }else if(fileName.toLowerCase().endsWith("xlsx")){
            this.wb = new XSSFWorkbook(is);
        }else{
            throw new RuntimeException("文档格式不正确");
        }
        if(this.wb.getNumberOfSheets()<1){
            throw new RuntimeException("文档中没有工作表");
        }
    }

    public InputStream getIs() {
        return is;
    }

    public void setIs(InputStream is) {
        this.is = is;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Workbook getWb() {
        return wb;
    }

    public void setWb(Workbook wb) {
        this.wb = wb;
    }

    /**
     * 从workbook文件对象中获得数据
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public List<Student> getDataList() throws IllegalAccessException, InstantiationException {
        List<Student> list = Lists.newArrayList();
        Sheet sheet = wb.getSheetAt(0);

        for (Row row:sheet) {
            if(row.getRowNum()<1) continue;//第一行跳过
            Student student = new Student();
            student.setName(row.getCell(0).getStringCellValue());
            student.setSex(row.getCell(1).getStringCellValue());
            student.setAge(String.valueOf(row.getCell(2).getNumericCellValue()));
            student.setAddress(row.getCell(3).getStringCellValue());
            student.setHigh(String.valueOf(row.getCell(4).getNumericCellValue()));
            list.add(student);
        }
        return list;
    }

    /**
     * 设置数据，设置模板文件并输出
     * @param fileName 模板文件名
     * @param studentList 设置数据的数据对象
     * @param propertyNum 作为模板的属性个数
     */
    public void exportTemplate(HttpServletResponse response,String fileName, List<Student> studentList, Integer propertyNum) throws IOException {
        //获得工作表对象
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        //创建一个Sheet
        Sheet sheet = xssfWorkbook.createSheet("学生信息");

        //设置单元格类型
        CellStyle cellStyle = xssfWorkbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        //创建标题
        Row title = sheet.createRow(0);
        title.createCell(0).setCellValue("学生姓名");
        title.createCell(1).setCellValue("学生性别");
        title.createCell(2).setCellValue("学生年龄");
        title.createCell(3).setCellValue("学生地址");
        title.createCell(4).setCellValue("学生身高");

        //循环设置数据
        for (int i = 0; i<studentList.size(); i++){
            Row row = sheet.createRow(i+1);
            Student stu = studentList.get(i);
            for (int j = 0; j<propertyNum; j++){

                Cell cell1 = row.createCell(0);
                cell1.setCellValue(stu.getName());
                cell1.setCellStyle(cellStyle);

                Cell cell2 = row.createCell(1);
                cell2.setCellValue(stu.getSex());
                cell2.setCellStyle(cellStyle);

                Cell cell3 = row.createCell(2);
                cell3.setCellValue(Integer.valueOf(stu.getAge()));
                cell3.setCellStyle(cellStyle);

                Cell cell4 = row.createCell(3);
                cell4.setCellValue(stu.getAddress());
                cell4.setCellStyle(cellStyle);

                Cell cell5 = row.createCell(4);
                cell5.setCellValue(Integer.valueOf(stu.getHigh()));
                cell5.setCellStyle(cellStyle);
            }
        }
        File file = new File("C:/template/");
        if(!file.exists()) file.mkdirs();
        FileOutputStream outputStream = new FileOutputStream("C:/template/student.xlsx");
        //保存
        xssfWorkbook.write(outputStream);
        xssfWorkbook.close();

    }
}
