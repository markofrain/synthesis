package com.fsats.synthesis.customizetag.util;

import com.fsats.synthesis.customizetag.entity.Grade;
import com.fsats.synthesis.customizetag.entity.Student;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * 学生的工具类
 */
public class GlobalUtil {

    static List<Student> studentList = Lists.newArrayList();
    static List<Grade> gradeList = Lists.newArrayList();

    /**
     * 静态加载，为列表添加数据
     */
    static {
        Grade onegrade = new Grade("1","一年级");
        gradeList.add(onegrade);
        Student student = new Student("1","陈小明","男","18","北京丰台","172");
        student.setGrade(onegrade);
        studentList.add(student);
    }

    /**
     * 获得学生姓名
     * @param index
     * @return
     */
    public static String getStudentName(int index){
        if(index<0||(index>studentList.size()-1)){
            return "";
        }
        return studentList.get(index).getName();
    }

    /**
     * 获得学生对象
     * @param index
     * @return
     */
    public static Student getStudent(int index){
        return studentList.get(index);
    }

    /**
     * 根据student对象获得id
     * @param student
     * @return
     */
    public static String getId(Student student){
        return student.getId();
    }

    /**
     * 通过id获得学生对象
     * @param id
     * @return
     */
    public static Student getStudent(String id){
        for (Student stu:studentList){
            if(stu.getId().equals(id)){
                return stu;
            }
        }
        return null;
    }

}
