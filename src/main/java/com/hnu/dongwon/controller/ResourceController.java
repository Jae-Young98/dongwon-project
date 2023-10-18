package com.hnu.dongwon.controller;

import com.hnu.dongwon.dto.WorkManageListResponseDto;
import com.hnu.dongwon.dto.WorkManageResponseDto;
import com.hnu.dongwon.service.SearchService;
import com.hnu.dongwon.service.WorkManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/resource-work")
public class ResourceController {

    private final WorkManageService workManageService;
    private final SearchService searchService;

    @GetMapping("/name-num")
    public String nameNumResult(Model model) {
        List<WorkManageListResponseDto> listDto = workManageService.findByCategoryCostAsc("성명군번불일치");
        if (!listDto.isEmpty()) {
            for (int i = 0; i < listDto.size(); i++) {
                String query = listDto.get(i).getQuery();

            }
        }
        int searchResult = 1;
        return "test";
    }

    @GetMapping("/reply-time")
    public String replyTime(Model model) {
        // 카테고리 단일로 찾는것도 만들어야함
        WorkManageResponseDto dto = workManageService.findByCategory("응소시간_수정대상");
        // List<Map<String, Object>> list = searchService.search(dto.getQuery());
        // 테스트용 더미 데이터 삽입
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("군번", i+1);
            map.put("학과", "테스트 학과");
            map.put("성명", "더미"+i);
            map.put("보류", "방침일부");
            map.put("응소시간", "6H이내");
            map.put("소속", "test");
            map.put("교직원학생구분", "test");
            list.add(map);
        }

        int searchResult = 1;
        if (list.isEmpty()) {
            searchResult = 0;
            model.addAttribute("searchResult", searchResult);
        } else {
            model.addAttribute("searchResult", searchResult);
            model.addAttribute("result", list);
        }

        return "tables-search";
    }

}
