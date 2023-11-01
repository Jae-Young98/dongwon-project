package com.hnu.dongwon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateDataService {
    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public void updateData() {
        String sql = "UPDATE 학적기초 SET 학적기초.구분 = new_school_record.CATEGORY, " +
                "학적기초.자기군번 = new_school_record.SERVICE_NO, " +
                "학적기초.단과대대학원 = new_school_record.COLLEGE, 학적기초.전공 = new_school_record.MAJOR, " +
                "학적기초.학과 = new_school_record.MAJOR_2, 학적기초.학습과정 = new_school_record.PROCESS, " +
                "학적기초.학번 = new_school_record.SCHOOL_ID, 학적기초.메일 = new_school_record.EMAIL, " +
                "학적기초.학년제 = new_school_record.GRADE_SET, 학적기초.학기제 = new_school_record.SEMESTER_SET, " +
                "학적기초.학년 = new_school_record.GRADE, 학적기초.이수학기 = new_school_record.COMPLETE_GRADE, " +
                "학적기초.학적상태 = new_school_record.STATUS, 학적기초.연락처 = new_school_record.CONTACT, " +
                "학적기초.핸드폰 = new_school_record.PHONE_NO, 학적기초.학적사유 = new_school_record.STATUS_REASON, " +
                "학적기초.변동일 = new_school_record.CHANGE_DT, 학적기초.주소 = new_school_record.ADDRESS, " +
                "학적기초.전출요청 = 'false' FROM 학적기초 INNER JOIN new_school_record " +
                "ON 학적기초.주민등록번호 = new_school_record.RESIDENT_REGISTRATION_NO" +
                " WHERE 학적기초.주민등록번호 is not null";

        jdbcTemplate.update(sql);
    }
}
