package com.hnu.dongwon.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WorkManageUpdateRequestDto {
    private String type;
    private int orderCost;
    private String name;
    private String query;
    private String description;
    private String others;

    @Builder
    public WorkManageUpdateRequestDto(String type, int orderCost, String name, String query, String description, String others) {
        this.type = type;
        this.orderCost = orderCost;
        this.name = name;
        this.query = query;
        this.description = description;
        this.others = others;
    }
}
