package com.fsats.synthesis.ztree;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestAreaDao {

    List<TestArea> get(Integer id);
}
