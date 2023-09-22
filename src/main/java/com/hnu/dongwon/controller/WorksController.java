package com.hnu.dongwon.controller;

import com.hnu.dongwon.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/works")
public class WorksController {

    private final SearchService searchService;
    private List<Map<String, Object>> dataSet;


    // 추후에 db에 있는 id 값 (쿼리명, sql문)으로 refactor

}
