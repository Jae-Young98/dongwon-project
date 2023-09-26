package com.hnu.dongwon.controller;

import com.hnu.dongwon.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/manage")
public class ManageController {

    private final SearchService searchService;
    private List<Map<String, Object>> dataSet;

    @GetMapping("/national-defense")
    public String nationalDefense() {
        return "manage-nationalDefense";
    }

    @GetMapping("/univ")
    public String univ() {
        return "manage-univ";
    }

    @GetMapping("/resource")
    public String resource() {
        return "manage-resource";
    }

    @GetMapping("/references")
    public String references() {
        return "manage-references";
    }

    @GetMapping("/training")
    public String training() {
        return "manage-training";
    }


    // 추후에 db에 있는 id 값 (쿼리명, sql문)으로 refactor

}
