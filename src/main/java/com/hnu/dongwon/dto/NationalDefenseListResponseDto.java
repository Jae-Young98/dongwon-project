package com.hnu.dongwon.dto;

import com.hnu.dongwon.entity.NationalDefense;
import lombok.Getter;

@Getter
public class NationalDefenseListResponseDto {

    private final Long id;
    private final String category;
    private final String type;
    private final int orderCost;
    private final String name;
    private final String query;
    private final String description;
    private final String others;

    public NationalDefenseListResponseDto(NationalDefense entity) {
        this.id = entity.getId();
        this.category = entity.getCategory();
        this.type = entity.getType();
        this.orderCost = entity.getOrderCost();
        this.name = entity.getName();
        this.query = entity.getQuery();
        this.description = entity.getDescription();
        this.others = entity.getOthers();
    }
}
