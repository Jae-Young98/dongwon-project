package com.hnu.dongwon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/univ")
public class UnivController {

    @GetMapping("/school-record")
    public String schoolRecord() {
        return "univ-data-update";
    }
}
