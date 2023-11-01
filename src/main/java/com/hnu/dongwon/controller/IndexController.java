package com.hnu.dongwon.controller;

import com.hnu.dongwon.repository.TestRepository;
import com.hnu.dongwon.service.NewSchoolRecordService;
import com.hnu.dongwon.service.SearchService;
import com.hnu.dongwon.service.UpdateDataService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class IndexController {

    @Autowired
    TestRepository testRepository;

    private final SearchService searchService;
    private final NewSchoolRecordService newSchoolRecordService;
    private final UpdateDataService updateDataService;

    @GetMapping("/")
    public String index(Model model, String str) {
        // model.addAttribute("str", str);
        return "index-real";
    }

    @GetMapping("/tables")
    public String tables(Model model, String str) {
        // model.addAttribute("str", str);
        return "tables";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/read")
    public String readExcel(@RequestParam("file")MultipartFile file, Model model) throws IOException {

        String extension = FilenameUtils.getExtension(file.getOriginalFilename()); // 3

        if (!extension.equals("xlsx") && !extension.equals("xls")) {
            throw new IOException("엑셀파일만 업로드 해주세요.");
        }

        Workbook workbook = null;

        if (extension.equals("xlsx")) {
            workbook = new XSSFWorkbook(file.getInputStream());
        }
        if (extension.equals("xls")) {
            workbook = new HSSFWorkbook(file.getInputStream());
        }

        newSchoolRecordService.deleteAll();
        newSchoolRecordService.saveAll(workbook);
        updateDataService.updateData();

        return "testView";
    }
}
