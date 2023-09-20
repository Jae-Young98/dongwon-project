package com.hnu.dongwon.controller;

import com.hnu.dongwon.dto.SchoolRecord;
import com.hnu.dongwon.repository.TestRepository;
import com.hnu.dongwon.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Controller
@RequiredArgsConstructor
public class IndexController {

    @Autowired
    TestRepository testRepository;

    private final SearchService searchService;

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

    @PostMapping("/tables/search")
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

        List<Map<String, Object>> list = testRepository.dbSearch(searchSyntax);

        // 리스트 키, 값 확인용
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

        List<SchoolRecord> recordList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            SchoolRecord record = new SchoolRecord();
            for (Map.Entry<String, Object> elem : list.get(i).entrySet()) {
                String key = elem.getKey();
                switch (key) {
                    case "구분" :
                        record.setCategory((String) elem.getValue());
                        break;
                    case "사번" :
                        record.setEmployeeId((String) elem.getValue());
                        break;
                    case "학번" :
                        record.setSchoolId((String) elem.getValue());
                        break;
                    case "군번" :
                        record.setServiceNum((String) elem.getValue());
                        break;
                    case "자기군번" :
                        record.setSelfServiceNum((String) elem.getValue());
                        break;
                    case "단과대대학원" :
                        record.setCollege((String) elem.getValue());
                        break;
                    case "학과" :
                        record.setMajor((String) elem.getValue());
                        break;
                }
            }
            recordList.add(record);
        }
        // model.addAttribute("data", recordList);
        // return "school";
        return "tables-search";
    }

    @PostMapping("/read")
    public String readExcel(@RequestParam("file")MultipartFile file, Model model) throws IOException {

//        List<ExcelData> dataList = new ArrayList<>();
//
//        String extension = FilenameUtils.getExtension(file.getOriginalFilename()); // 3
//
//        if (!extension.equals("xlsx") && !extension.equals("xls")) {
//            throw new IOException("엑셀파일만 업로드 해주세요.");
//        }
//
//        Workbook workbook = null;
//
//        if (extension.equals("xlsx")) {
//            workbook = new XSSFWorkbook(file.getInputStream());
//        } else if (extension.equals("xls")) {
//            workbook = new HSSFWorkbook(file.getInputStream());
//        }
//
//        Sheet worksheet = workbook.getSheetAt(0);
//
//        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) { // 4
//
//            Row row = worksheet.getRow(i);
//
//            ExcelData data = new ExcelData();
//
//            data.setNum((int) row.getCell(0).getNumericCellValue());
//            data.setName(row.getCell(1).getStringCellValue());
//            data.setEmail(row.getCell(2).getStringCellValue());
//
//            dataList.add(data);
//        }
//
//        model.addAttribute("data", dataList); // 5
//
//        return "testView";


        ArrayList<String> keySet = new ArrayList<>();

        String extension = FilenameUtils.getExtension(file.getOriginalFilename()); // 3

        if (!extension.equals("xlsx") && !extension.equals("xls")) {
            throw new IOException("엑셀파일만 업로드 해주세요.");
        }

        Workbook workbook = null;

        if (extension.equals("xlsx")) {
            workbook = new XSSFWorkbook(file.getInputStream());
        } else if (extension.equals("xls")) {
            workbook = new HSSFWorkbook(file.getInputStream());
        }

        Sheet worksheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = worksheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // 0번 째 행 (분류) 추출
            if (row.getRowNum() == 0) {
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    keySet.add(cell.getStringCellValue());
                }
                continue;
            }

            Iterator<Cell> cellIterator = row.cellIterator();


            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    case NUMERIC:
                        System.out.print((int) cell.getNumericCellValue() + "\t");
                        break;
                    case STRING:
                        System.out.print(cell.getStringCellValue() + "\t");
                        break;
                }
            }
            System.out.println();
        }
        for (int i = 0; i < keySet.size(); i++) {
            System.out.println(keySet.get(i));
        }

        return "testView";
    }
}
