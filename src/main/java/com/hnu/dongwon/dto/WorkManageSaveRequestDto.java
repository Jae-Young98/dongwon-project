package com.hnu.dongwon.dto;

import com.hnu.dongwon.entity.WorkManage;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WorkManageSaveRequestDto {
    private String work;
    private String category;
    private String type;
    private int orderCost;
    private String name;
    private String query;
    private String description;
    private String others;

    @Builder
    public WorkManageSaveRequestDto(String work, String category, String type, int orderCost, String name, String query, String description, String others) {
        this.work = work;
        this.category = category;
        this.type = type;
        this.orderCost = orderCost;
        this.name = name;
        this.query = query;
        this.description = description;
        this.others = others;
    }

    public WorkManage toEntity() {
        return WorkManage.builder()
                .work(work)
                .category(category)
                .type(type)
                .orderCost(orderCost)
                .name(name)
                .query(query)
                .description(description)
                .others(others)
                .build();
    }
}