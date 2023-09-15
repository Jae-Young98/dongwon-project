package com.hnu.dongwon.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TestRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Map<String, Object>> getTables() {
        List<Map<String, Object>> tableList = new ArrayList<>();
        tableList.addAll(jdbcTemplate.queryForList("select * from Dongwontemp.dbo.교육결산"));
        return tableList;
    }

    // sql문으로 검색 후 리스트에 저장
    public List<Map<String, Object>> dbSearch(String searchSyntax) {
        List<Map<String, Object>> tableList = new ArrayList<>();
        tableList.addAll(jdbcTemplate.queryForList(searchSyntax));
        return tableList;
    }
}
