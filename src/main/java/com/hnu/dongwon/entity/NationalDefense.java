package com.hnu.dongwon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Manage_NationalDefense")
@Entity
public class NationalDefense {

    // 실제 DB의 테이블과 매핑, 객체
    // persistent 목적의 객체이기 때문에, request, response 값 전달 용도로 사용 x
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 업무 분류 ex ) 국방자료 업데이트, 대학자료 업데이트 ...
    @Column
    private String work;

    @Column
    private String category;

    @Column
    private String type;

    @Column
    private int orderCost;

    @Column
    private String name;

    @Column
    private String query;

    @Column
    private String description;

    @Column
    private String others;

    public void update(String type, int orderCost, String name, String query, String description, String others) {
        this.type = type;
        this.orderCost = orderCost;
        this.name = name;
        this.query = query;
        this.description = description;
        this.others = others;
    }
}
