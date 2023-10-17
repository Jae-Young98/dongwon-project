package com.hnu.dongwon;

import com.hnu.dongwon.dto.WorkManageSaveRequestDto;
import com.hnu.dongwon.dto.WorkManageUpdateRequestDto;
import com.hnu.dongwon.entity.WorkManage;
import com.hnu.dongwon.repository.WorkManageRepository;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ManageApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    WorkManageRepository workManageRepository;

    @AfterEach
    public void clear() {
        workManageRepository.deleteAll();
    }

    @Test
    public void ND_Save() {
        // given
        String category = "편성카드";
        String type = "전처리";
        int orderCost = 1;
        String name = "삭제_국동체_소속부대별";
        String query = "test Query";
        String description = "asdafasf";
        String others = "aaaa";
        WorkManageSaveRequestDto requestDto = WorkManageSaveRequestDto.builder()
                .category(category)
                .type(type)
                .orderCost(orderCost)
                .name(name)
                .query(query)
                .description(description)
                .others(others)
                .build();
        String url = "http://localhost:" + port + "/api/nd-data";

        // when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<WorkManage> dataList = workManageRepository.findAll();
        assertThat(dataList.get(0).getCategory()).isEqualTo(category);
        assertThat(dataList.get(0).getQuery()).isEqualTo(query);
        assertThat(dataList.get(0).getName()).isEqualTo(name);

    }

    @Test
    public void ND_Update() {
        // given
        String category = "편성카드";
        String type = "전처리";
        int orderCost = 1;
        String name = "삭제_국동체_소속부대별";
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
        Long updateId = saveData.getId();
        String expectedDescription = "update test";

        WorkManageUpdateRequestDto requestDto = WorkManageUpdateRequestDto.builder()
                .description(expectedDescription)
                .build();

        String url = "http://localhost:" + port + "/api/nd-data/" + updateId;

        HttpEntity<WorkManageUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        // when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<WorkManage> dataList = workManageRepository.findAll();
        assertThat(dataList.get(1).getDescription()).isEqualTo(expectedDescription);
        System.err.println(dataList.get(1).getDescription());
    }
}
