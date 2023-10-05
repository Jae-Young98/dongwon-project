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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public void update(String name, String query, String description, String others) {
        this.name = name;
        this.query = query;
        this.description = description;
        this.others = others;
    }
}
