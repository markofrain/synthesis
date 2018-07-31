package com.fsats.synthesis.ztree;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaTreeDao {

    public List<AreaTree> findAll();
}
