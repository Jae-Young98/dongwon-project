package com.hnu.dongwon.service;

import com.hnu.dongwon.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class SearchService {

    private final TestRepository testRepository;
    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public List<Map<String, Object>> search(String searchSyntax) {
        List<Map<String, Object>> tableList = new ArrayList<>();
        tableList.addAll(jdbcTemplate.queryForList(searchSyntax));

        return tableList;
    }
}
