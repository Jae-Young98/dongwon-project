package com.hnu.dongwon;

import com.hnu.dongwon.dto.WorkManageResponseDto;
import com.hnu.dongwon.dto.WorkManageSaveRequestDto;
import com.hnu.dongwon.entity.WorkManage;
import com.hnu.dongwon.repository.WorkManageRepository;
import com.hnu.dongwon.service.WorkManageService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkManageRepoTest {

    @Autowired
    WorkManageRepository workManageRepository;

    @Autowired
    WorkManageService workManageService;

    @After
    public void cleanUp() {
        workManageRepository.deleteAll();
    }

    @Test
    public void 데이터_삽입() {
        String work = "국방자료_업데이트";
        String category = "편성카드";
        String type = "전처리";
        int orderCost = 1;
        String name = "삭제_국동체_소속부대별";
        String query = "test Query";
        String description = "asdafasf";
        String others = "aaaa";

        WorkManageSaveRequestDto requestDto = WorkManageSaveRequestDto.builder()
                .work(work)
                .category(category)
                .type(type)
                .orderCost(orderCost)
                .name(name)
                .query(query)
                .description(description)
                .others(others)
                .build();
        workManageService.save(requestDto);

        List<WorkManage> list = workManageRepository.findAll();
        assertThat(list.get(0).getCategory()).isEqualTo(category);
        assertThat(list.get(0).getName()).isEqualTo(name);
        System.err.println(list.get(0).getName());
    }

    @Test
    public void 데이터_이름_검색() {
        String category = "test";
        String type = "전처리";
        int orderCost = 1;
        String name = "테스트 네임";
        String query = "test Query";
        String description = "asdafasf";
        String others = "aaaa";

        WorkManage saveData = workManageRepository.save(WorkManage.builder()
                .category(category)
                .type(type)
                .orderCost(orderCost)
                .name(name)
                .query(query)
                .description(description)
                .others(others)
                .build());

        WorkManageResponseDto data = workManageService.findById(saveData.getId());
        WorkManageResponseDto find = workManageService.findByName(name);
        assertThat(data.getName()).isEqualTo(find.getName());
        System.err.println(data.getName());
        System.err.println(find.getName());

    }

    @Test
    public void get_Category() {
        int idx = 1;
        String category = "편성카드";
        String type = "전처리";
        int orderCost = 1;
        String name = "테스트 네임"+idx;
        String query = "test Query";
        String description = "asdafasf";
        String others = "aaaa";

        for (int i = 0; i < 5; i++) {
            WorkManageSaveRequestDto requestDto = WorkManageSaveRequestDto.builder()
                    .category(category)
                    .type(type)
                    .orderCost(orderCost)
                    .name(name)
                    .query(query)
                    .description(description)
                    .others(others)
                    .build();
            workManageService.save(requestDto);
            WorkManageSaveRequestDto requestDto2 = WorkManageSaveRequestDto.builder()
                    .category("전투편성")
                    .type(type)
                    .orderCost(orderCost)
                    .name(name)
                    .query(query)
                    .description(description)
                    .others(others)
                    .build();
            workManageService.save(requestDto2);
            idx++;
            orderCost++;
        }
        List<WorkManage> dataList = workManageRepository.findByCategoryCostAsc(category);
        assertThat(dataList.get(0).getCategory()).isEqualTo("편성카드");

        for (WorkManage data : dataList) {
            System.err.println("id : " + data.getId());
            System.err.println("category : " + data.getCategory());
            System.err.println("orderCost : " + data.getOrderCost());
        }
    }

    @Test
    public void get_work() {
        int idx = 1;
        String work = "국방자료_업데이트";
        String category = "편성카드";
        String type = "전처리";
        int orderCost = 1;
        String name = "테스트 네임"+idx;
        String query = "test Query";
        String description = "asdafasf";
        String others = "aaaa";

        for (int i = 0; i < 5; i++) {
            WorkManageSaveRequestDto requestDto = WorkManageSaveRequestDto.builder()
                    .work(work)
                    .category(category)
                    .type(type)
                    .orderCost(orderCost)
                    .name(name)
                    .query(query)
                    .description(description)
                    .others(others)
                    .build();
            workManageService.save(requestDto);
            WorkManageSaveRequestDto requestDto2 = WorkManageSaveRequestDto.builder()
                    .work("자원관리_점검")
                    .category("전투편성")
                    .type(type)
                    .orderCost(orderCost)
                    .name(name)
                    .query(query)
                    .description(description)
                    .others(others)
                    .build();
            workManageService.save(requestDto2);
            idx++;
            orderCost++;
        }
        List<WorkManage> dataList1 = workManageRepository.findByWorkIs(work);
        List<WorkManage> dataList2 = workManageRepository.findByWorkIs("자원관리_점검");
        assertThat(dataList1.get(0).getWork()).isEqualTo(work);
        assertThat(dataList2.get(0).getWork()).isEqualTo("자원관리_점검");
        System.err.println(dataList1.get(0).getWork());
        System.err.println(dataList2.get(0).getWork());
    }

//    @Test
//    @Order(1)
//    public void insertTest() {
//        String type = "testType";
//        int orderCost = 1;
//
//        manageNationalDefenseRepository.save(NationalDefense.builder()
//                .category("test..")
//                .type(type)
//                .orderCost(orderCost)
//                .name("test")
//                .query("selectTestQuery")
//                .description("test")
//                .others("test")
//                .build());
//
//        List<NationalDefense> nationalDefenseList = manageNationalDefenseRepository.findAll();
//
//        NationalDefense nationalDefense = nationalDefenseList.get(0);
//        assertThat(nationalDefense.getType()).isEqualTo(type);
//        assertThat(nationalDefense.getOrderCost()).isEqualTo(orderCost);
//    }
//
//    @Test
//    @Order(2)
//    public void selectTest() {
//        String name = "test";
//        String query = "selectTestQuery";
//
//        Optional<NationalDefense> result = manageNationalDefenseRepository.findById(1L);
//
//        if (result.isPresent()) {
//            NationalDefense nationalDefense = result.get();
//            System.err.println(nationalDefense);
//            System.err.println(nationalDefense.getQuery());
//        } else {
//            System.err.println("No value");
//        }
//    }

}
