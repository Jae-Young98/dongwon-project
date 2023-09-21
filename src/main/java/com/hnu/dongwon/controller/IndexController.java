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
