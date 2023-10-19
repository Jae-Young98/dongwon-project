package com.hnu.dongwon.dto;

import com.hnu.dongwon.entity.NewSchoolRecord;
import lombok.Getter;

@Getter
public class NewSchoolRecordResponseDto {

    private Long ID;
    private String CATEGORY; // 구분
    private String COLLEGE; // 단과대 대학원
    private String MAJOR; // 전공
    private String MAJOR_2; // 학과
    private String PROCESS; // 학습과정
    private String SCHOOL_ID; // 학번
    private String RESIDENT_REGISTRATION_NO; // 주민번호
    private String BIRTH; // 생년월일
    private String SERVICE_NO; // 군번
    private int GRADE_SET; // 학년제
    private int SEMESTER_SET; // 학기제
    private int GRADE; // 학년
    private int COMPLETE_GRADE; // 이수학기
    private String NAME; // 성명
    private String STATUS; // 학적상태
    private String STATUS_REASON; // 학적사유
    private String ADDRESS; // 주소
    private String CONTACT; // 연락처
    private String PHONE_NO; // 휴대폰 번호
    private String EMAIL; // EMAIL
    private String CHANGE_DT; // 변동일

    public NewSchoolRecordResponseDto(NewSchoolRecord entity) {
        this.CATEGORY = entity.getCATEGORY();
        this.COLLEGE = entity.getCOLLEGE();
        this.MAJOR = entity.getMAJOR();
        this.MAJOR_2 = entity.getMAJOR_2();
        this.PROCESS = entity.getPROCESS();
        this.SCHOOL_ID = entity.getSCHOOL_ID();
        this.RESIDENT_REGISTRATION_NO = entity.getRESIDENT_REGISTRATION_NO();
        this.BIRTH = entity.getBIRTH();
        this.SERVICE_NO = entity.getSERVICE_NO();
        this.GRADE_SET = entity.getGRADE_SET();
        this.SEMESTER_SET = entity.getSEMESTER_SET();
        this.GRADE = entity.getGRADE();
        this.COMPLETE_GRADE = entity.getCOMPLETE_GRADE();
        this.NAME = entity.getNAME();
        this.STATUS = entity.getSTATUS();
        this.STATUS_REASON = entity.getSTATUS_REASON();
        this.ADDRESS = entity.getADDRESS();
        this.CONTACT = entity.getCONTACT();
        this.PHONE_NO = entity.getPHONE_NO();
        this.EMAIL = entity.getEMAIL();
        this.CHANGE_DT = entity.getCHANGE_DT();
    }
}
