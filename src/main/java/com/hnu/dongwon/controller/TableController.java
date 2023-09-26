package com.hnu.dongwon.controller;

import com.hnu.dongwon.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tables")
public class TableController {

    private final SearchService searchService;
    private List<Map<String, Object>> dataSet;

    @PostMapping("/search")
    public String sqlSearchResult(Model model, @RequestParam("sql") String searchSyntax) {
        // model.addAttribute("result", testRepository.dbSearch(searchSyntax));
        // 위 리포지토리 사용x -> 서비스화
        int searchResult = 1;
        List<Map<String, Object>> table = searchService.search(searchSyntax);
        if (table.isEmpty()) {
            searchResult = 0;
            model.addAttribute("searchResult", searchResult);
        } else {
            model.addAttribute("searchResult", searchResult);
            model.addAttribute("result", searchService.search(searchSyntax));
        }

//        List<Map<String, Object>> list = testRepository.dbSearch(searchSyntax);
//
//         리스트 키, 값 확인용
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("entrySet : " + list.get(i).entrySet());
//            for (Map.Entry<String, Object> elem : list.get(i).entrySet()) {
//                System.out.println("키 : " + elem.getKey() + ", 값 : " + elem.getValue() + "\t");
//                if (elem.getKey().equals("전출요청일자")) {
//                    if (elem.getValue() != null) {
//                        System.out.println("전출요청일자 : " + elem.getValue().getClass());
//                    }
//                }
//            }
//        }
//
//        List<SchoolRecord> recordList = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            SchoolRecord record = new SchoolRecord();
//            for (Map.Entry<String, Object> elem : list.get(i).entrySet()) {
//                String key = elem.getKey();
//                switch (key) {
//                    case "구분" :
//                        record.setCategory((String) elem.getValue());
//                        break;
//                    case "사번" :
//                        record.setEmployeeId((String) elem.getValue());
//                        break;
//                    case "학번" :
//                        record.setSchoolId((String) elem.getValue());
//                        break;
//                    case "군번" :
//                        record.setServiceNum((String) elem.getValue());
//                        break;
//                    case "자기군번" :
//                        record.setSelfServiceNum((String) elem.getValue());
//                        break;
//                    case "단과대대학원" :
//                        record.setCollege((String) elem.getValue());
//                        break;
//                    case "학과" :
//                        record.setMajor((String) elem.getValue());
//                        break;
//                }
//            }
//            recordList.add(record);
//        }
//         model.addAttribute("data", recordList);
//         return "school";
        return "tables-search";
    }

    @PostMapping("/toJson")
    public String jsonToObject(@RequestBody List<Map<String, Object>> jsonData) {
        //         리스트 키, 값 확인용
        for (int i = 0; i < jsonData.size(); i++) {
            System.out.println("entrySet : " + jsonData.get(i).entrySet());
            for (Map.Entry<String, Object> elem : jsonData.get(i).entrySet()) {
                System.out.println("키 : " + elem.getKey() + ", 값 : " + elem.getValue() + "\t");
//                if (elem.getKey().equals("전출요청일자")) {
//                    if (elem.getValue() != null) {
//                        System.out.println("전출요청일자 : " + elem.getValue().getClass());
//                    }
//                }
            }
        }
        dataSet = jsonData;
        return "redirect:/";
    }

    @GetMapping("/download")
    public void download(HttpServletResponse res) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        // 헤더 생성
        Row headerRow = sheet.createRow(0);
        int headerCellNum = 0;
        for (String key : dataSet.get(0).keySet()) {
            Cell headerCell = headerRow.createCell(headerCellNum++);
            headerCell.setCellValue(key);
        }

        // 행 생성
        int rowNum = 1;
        for (Map<String, Object> data : dataSet) {
            Row row = sheet.createRow(rowNum++);
            int cellNum = 0;
            for (String key : data.keySet()) {
                Cell cell = row.createCell(cellNum++);
                cell.setCellValue(data.get(key).toString());
            }
        }

        String fileName = "test";
        res.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        workbook.write(res.getOutputStream());
        workbook.close();
    }
}
