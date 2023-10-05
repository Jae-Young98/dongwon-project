package com.hnu.dongwon.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NationalDefenseUpdateRequestDto {
    private String name;
    private String query;
    private String description;
    private String others;

    @Builder
    public NationalDefenseUpdateRequestDto(String name, String query, String description, String others) {
        this.name = name;
        this.query = query;
        this.description = description;
        this.others = others;
    }
}
