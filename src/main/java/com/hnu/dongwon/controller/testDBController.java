package com.hnu.dongwon.controller;

import com.hnu.dongwon.dao.SchoolRecord;
import com.hnu.dongwon.repository.TestRepository;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/db")
public class testDBController {

    @Autowired
    TestRepository testRepository;

    @GetMapping("/test")
    public List<Map<String, Object>> getTables() {
        return testRepository.getTables();
    }


    // sql문으로 검색처리 컨트롤러
    @GetMapping("/search")
    public String search(Model model, String str) {
        model.addAttribute("str", str);
        return "search";
    }

    // search 폼에서 입력받은 sql문 처리
    @PostMapping("/search/result")
    public String dbSearch(Model model, @RequestParam("sql") String searchSyntax) {
        model.addAttribute("sql", searchSyntax);
        model.addAttribute("result", testRepository.dbSearch(searchSyntax));
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
        model.addAttribute("result", list);
        return "result";
    }

}
