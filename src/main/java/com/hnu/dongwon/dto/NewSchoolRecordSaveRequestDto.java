package com.hnu.dongwon.dto;

import com.hnu.dongwon.entity.NewSchoolRecord;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NewSchoolRecordSaveRequestDto {

    public static final String EXCEPT_WORDS= "[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]";

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

    @Builder
    public NewSchoolRecordSaveRequestDto(String CATEGORY, String COLLEGE, String MAJOR, String MAJOR_2, String PROCESS, String SCHOOL_ID, String RESIDENT_REGISTRATION_NO, String BIRTH, String SERVICE_NO, int GRADE_SET, int SEMESTER_SET, int GRADE, int COMPLETE_GRADE, String NAME, String STATUS, String STATUS_REASON, String ADDRESS, String CONTACT, String PHONE_NO, String EMAIL, String CHANGE_DT) {
        this.CATEGORY = CATEGORY;
        this.COLLEGE = COLLEGE;
        this.MAJOR = MAJOR;
        this.MAJOR_2 = MAJOR_2;
        this.PROCESS = PROCESS;
        this.SCHOOL_ID = SCHOOL_ID;
        this.RESIDENT_REGISTRATION_NO = RESIDENT_REGISTRATION_NO;
        this.BIRTH = BIRTH;
        this.SERVICE_NO = SERVICE_NO;
        this.GRADE_SET = GRADE_SET;
        this.SEMESTER_SET = SEMESTER_SET;
        this.GRADE = GRADE;
        this.COMPLETE_GRADE = COMPLETE_GRADE;
        this.NAME = NAME;
        this.STATUS = STATUS;
        this.STATUS_REASON = STATUS_REASON;
        this.ADDRESS = ADDRESS;
        this.CONTACT = CONTACT.replaceAll(EXCEPT_WORDS, "");
        this.PHONE_NO = PHONE_NO.replaceAll(EXCEPT_WORDS, "");
        this.EMAIL = EMAIL;
        this.CHANGE_DT = CHANGE_DT;
    }

    public NewSchoolRecord toEntity() {
        return NewSchoolRecord.builder()
                .CATEGORY(CATEGORY)
                .COLLEGE(COLLEGE)
                .MAJOR(MAJOR)
                .MAJOR_2(MAJOR_2)
                .PROCESS(PROCESS)
                .SCHOOL_ID(SCHOOL_ID)
                .RESIDENT_REGISTRATION_NO(RESIDENT_REGISTRATION_NO)
                .BIRTH(BIRTH)
                .SERVICE_NO(SERVICE_NO)
                .GRADE_SET(GRADE_SET)
                .SEMESTER_SET(SEMESTER_SET)
                .GRADE(GRADE)
                .COMPLETE_GRADE(COMPLETE_GRADE)
                .NAME(NAME)
                .STATUS(STATUS)
                .STATUS_REASON(STATUS_REASON)
                .ADDRESS(ADDRESS)
                .CONTACT(CONTACT.replaceAll(EXCEPT_WORDS, ""))
                .PHONE_NO(PHONE_NO.replaceAll(EXCEPT_WORDS, ""))
                .EMAIL(EMAIL)
                .CHANGE_DT(CHANGE_DT)
                .build();
    }
}
