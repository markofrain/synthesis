package com.fsats.synthesis.ztree;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaTreeService {

    @Autowired
    private AreaTreeDao areaTreeDao;
    @Autowired
    private TestAreaDao testAreaDao;

    public List<AreaTree> findAll(){
        List<AreaTree> areaTrees = areaTreeDao.findAll();
        System.out.println("========" + areaTrees.size());
        return areaTrees;
    }

    public List<AreaTree> getRoot(){
        return areaTreeDao.getRoot();
    }

    public List<AreaTree> get(Integer id){
        return areaTreeDao.get(id);
    }

    public List<TestArea> getTestArea(Integer id){
        return testAreaDao.get(id);
    }

    /**
     * 使用pageHelper分页
     * @param pageNum 第几页
     * @param pageSize 每页显示条数
     * @return
     */
    public PageInfo<AreaTree> pageList(Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<AreaTree> areaTreeList = areaTreeDao.findAll();
        PageInfo<AreaTree> pageInfo = new PageInfo<AreaTree>(areaTreeList);
        return pageInfo;
    }
}
