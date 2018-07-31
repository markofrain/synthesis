package com.fsats.synthesis.ztree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaTreeService {

    @Autowired
    private AreaTreeDao areaTreeDao;

    public List<AreaTree> findAll(){
        List<AreaTree> areaTrees = areaTreeDao.findAll();
        System.out.println("========" + areaTrees.size());
        return areaTrees;
    }
}
