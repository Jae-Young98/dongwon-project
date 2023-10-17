package com.hnu.dongwon.controller;

import com.hnu.dongwon.dto.WorkManageListResponseDto;
import com.hnu.dongwon.service.WorkManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/resource")
public class ResourceController {

    private final WorkManageService workManageService;

}
