package com.hnu.dongwon.dto;

import com.hnu.dongwon.entity.NationalDefense;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.formula.functions.Na;

@Getter
@NoArgsConstructor
public class NationalDefenseSaveRequestDto {
    private String category;
    private String type;
    private int orderCost;
    private String name;
    private String query;
    private String description;
    private String others;

    @Builder
    public NationalDefenseSaveRequestDto(String category, String type, int orderCost, String name, String query, String description, String others) {
        this.category = category;
        this.type = type;
        this.orderCost = orderCost;
        this.name = name;
        this.query = query;
        this.description = description;
        this.others = others;
    }

    public NationalDefense toEntity() {
        return NationalDefense.builder()
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