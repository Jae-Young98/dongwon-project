package com.hnu.dongwon.dto;

import com.hnu.dongwon.entity.WorkManage;
import lombok.Getter;

@Getter
public class WorkManageResponseDto {
    private Long id;
    private String work;
    private String category;
    private String type;
    private int orderCost;
    private String name;
    private String query;
    private String description;
    private String others;

    public WorkManageResponseDto(WorkManage entity) {
        this.id = entity.getId();
        this.work = entity.getWork();
        this.category = entity.getCategory();
        this.type = entity.getType();
        this.orderCost = entity.getOrderCost();
        this.name = entity.getName();
        this.query = entity.getQuery();
        this.description = entity.getDescription();
        this.others = entity.getOthers();
    }
}
