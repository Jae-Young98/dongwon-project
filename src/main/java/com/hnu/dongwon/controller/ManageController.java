package com.hnu.dongwon.controller;

import com.hnu.dongwon.dto.WorkManageResponseDto;
import com.hnu.dongwon.service.WorkManageService;
import com.hnu.dongwon.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/manage")
public class ManageController {

    private final WorkManageService workManageService;
    private final SearchService searchService;
    private List<Map<String, Object>> dataSet;

    @GetMapping("/national-defense")
    public String nationalDefense(Model model) {
        model.addAttribute("datas", workManageService.findWorkAsc("국방자료업데이트"));

        return "manage-nationalDefense";
    }

    @GetMapping("/national-defense/{id}")
    public String nationalDefenseUpdate(@PathVariable Long id, Model model) {
        WorkManageResponseDto dto = workManageService.findById(id);
        model.addAttribute("datas", workManageService.findWorkAsc("국방자료업데이트"));
        model.addAttribute("data", dto);

        return "ND-update";
    }

    @GetMapping("/univ")
    public String univ() {
        return "manage-univ";
    }

    @GetMapping("/resource")
    public String resource(Model model) {
        model.addAttribute("datas", workManageService.findWorkAsc("자원관리점검"));
        return "manage-resource";
    }

    @GetMapping("/resource/{id}")
    public String resourceUpdate(@PathVariable Long id, Model model) {
        WorkManageResponseDto dto = workManageService.findById(id);
        model.addAttribute("datas", workManageService.findWorkAsc("자원관리점검"));
        model.addAttribute("data", dto);

        return "resource-update";
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
