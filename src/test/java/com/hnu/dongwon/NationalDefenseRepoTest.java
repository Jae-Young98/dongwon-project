package com.hnu.dongwon;

import com.hnu.dongwon.dto.NationalDefenseListResponseDto;
import com.hnu.dongwon.dto.NationalDefenseResponseDto;
import com.hnu.dongwon.dto.NationalDefenseSaveRequestDto;
import com.hnu.dongwon.entity.NationalDefense;
import com.hnu.dongwon.repository.ManageNationalDefenseRepository;
import com.hnu.dongwon.service.NationalDefenseService;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NationalDefenseRepoTest {

    @Autowired
    ManageNationalDefenseRepository manageNationalDefenseRepository;

    @Autowired
    NationalDefenseService nationalDefenseService;

    @After
    public void cleanUp() {
        manageNationalDefenseRepository.deleteAll();
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

        NationalDefenseSaveRequestDto requestDto = NationalDefenseSaveRequestDto.builder()
                .work(work)
                .category(category)
                .type(type)
                .orderCost(orderCost)
                .name(name)
                .query(query)
                .description(description)
                .others(others)
                .build();
        nationalDefenseService.save(requestDto);

        List<NationalDefense> list = manageNationalDefenseRepository.findAll();
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

        NationalDefense saveData = manageNationalDefenseRepository.save(NationalDefense.builder()
                .category(category)
                .type(type)
                .orderCost(orderCost)
                .name(name)
                .query(query)
                .description(description)
                .others(others)
                .build());

        NationalDefenseResponseDto data = nationalDefenseService.findById(saveData.getId());
        NationalDefenseResponseDto find = nationalDefenseService.findByName(name);
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
            NationalDefenseSaveRequestDto requestDto = NationalDefenseSaveRequestDto.builder()
                    .category(category)
                    .type(type)
                    .orderCost(orderCost)
                    .name(name)
                    .query(query)
                    .description(description)
                    .others(others)
                    .build();
            nationalDefenseService.save(requestDto);
            NationalDefenseSaveRequestDto requestDto2 = NationalDefenseSaveRequestDto.builder()
                    .category("전투편성")
                    .type(type)
                    .orderCost(orderCost)
                    .name(name)
                    .query(query)
                    .description(description)
                    .others(others)
                    .build();
            nationalDefenseService.save(requestDto2);
            idx++;
            orderCost++;
        }
        List<NationalDefense> dataList = manageNationalDefenseRepository.findByCategoryIs(category);
        assertThat(dataList.size()).isEqualTo(5);

        for (NationalDefense data : dataList) {
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
            NationalDefenseSaveRequestDto requestDto = NationalDefenseSaveRequestDto.builder()
                    .work(work)
                    .category(category)
                    .type(type)
                    .orderCost(orderCost)
                    .name(name)
                    .query(query)
                    .description(description)
                    .others(others)
                    .build();
            nationalDefenseService.save(requestDto);
            NationalDefenseSaveRequestDto requestDto2 = NationalDefenseSaveRequestDto.builder()
                    .work("자원관리_점검")
                    .category("전투편성")
                    .type(type)
                    .orderCost(orderCost)
                    .name(name)
                    .query(query)
                    .description(description)
                    .others(others)
                    .build();
            nationalDefenseService.save(requestDto2);
            idx++;
            orderCost++;
        }
        List<NationalDefense> dataList1 = manageNationalDefenseRepository.findByWorkIs(work);
        List<NationalDefense> dataList2 = manageNationalDefenseRepository.findByWorkIs("자원관리_점검");
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
