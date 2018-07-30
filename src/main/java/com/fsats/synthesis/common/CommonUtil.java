package com.fsats.synthesis.common;

import com.fsats.synthesis.jquerytreetable.entity.Area;
import com.google.common.collect.Lists;

import java.util.List;

public class CommonUtil {
    public static List<Area> areaList = Lists.newArrayList();


    static {
        Area area1 = new Area("1","中国","0","1");

        Area area2 = new Area("2","北京市","1","2");
        Area area3 = new Area("3","山东省","1","2");
        Area area4 = new Area("4","江苏省","1","2");

        Area area5 = new Area("5","丰台区","2","3");
        Area area6 = new Area("6","海淀区","2","3");
        Area area7 = new Area("7","西城区","2","3");
        Area area8 = new Area("8","菏泽市","3","3");
        Area area9 = new Area("9","青岛市","3","3");
        Area area10 = new Area("10","南京市","4","3");

        Area area11 = new Area("11","大红门镇","5","4");
        Area area12 = new Area("12","南苑镇","5","4");
        Area area13 = new Area("13","菏泽的某个镇","8","4");

        areaList.add(area1);
        areaList.add(area2);
        areaList.add(area3);
        areaList.add(area4);
        areaList.add(area5);
        areaList.add(area6);
        areaList.add(area7);
        areaList.add(area8);
        areaList.add(area9);
        areaList.add(area10);
        areaList.add(area11);
        areaList.add(area12);
        areaList.add(area13);
    }


    public static String getAreaType(String type){
        switch (type){
            case "1":
                return "国家";
            case "2":
                return "省份、直辖市";
            case "3":
                return "市";
            case "4":
                return "区县";
        }
        return "";
    }
}
