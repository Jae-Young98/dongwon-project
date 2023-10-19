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
@Table(name="new_school_record")
@Entity
public class NewSchoolRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column
    private String CATEGORY; // 구분

    @Column
    private String COLLEGE; // 단과대 대학원

    @Column
    private String MAJOR; // 전공

    @Column
    private String MAJOR_2; // 학과

    @Column
    private String PROCESS; // 학습과정

    @Column
    private String SCHOOL_ID; // 학번

    @Column
    private String RESIDENT_REGISTRATION_NO; // 주민번호

    @Column
    private String BIRTH; // 생년월일

    @Column
    private String SERVICE_NO; // 군번

    @Column
    private int GRADE_SET; // 학년제

    @Column
    private int SEMESTER_SET; // 학기제

    @Column
    private int GRADE; // 학년

    @Column
    private int COMPLETE_GRADE; // 이수학기

    @Column
    private String NAME; // 성명

    @Column
    private String STATUS; // 학적상태

    @Column
    private String STATUS_REASON; // 학적사유

    @Column
    private String ADDRESS; // 주소

    @Column
    private String CONTACT; // 연락처

    @Column
    private String PHONE_NO; // 휴대폰 번호

    @Column
    private String EMAIL; // EMAIL

    @Column
    private String CHANGE_DT; // 변동일
}
