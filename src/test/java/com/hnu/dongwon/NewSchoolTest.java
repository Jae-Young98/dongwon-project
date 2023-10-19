package com.hnu.dongwon;

import com.hnu.dongwon.dto.NewSchoolRecordResponseDto;
import com.hnu.dongwon.dto.NewSchoolRecordSaveRequestDto;
import com.hnu.dongwon.repository.NewSchoolRecordRepository;
import com.hnu.dongwon.service.NewSchoolRecordService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewSchoolTest {

    @Autowired
    NewSchoolRecordRepository newSchoolRecordRepository;

    @Autowired
    NewSchoolRecordService newSchoolRecordService;

    @After
    public void clenUp() {
        newSchoolRecordRepository.deleteAll();
    }

    @Test
    public void 신학적_삽입() {
        final String EXCEPT_WORDS= "[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]";

        String CATEGORY = "학부"; // 구분
        String COLLEGE = "문과대학"; // 단과대 대학원
        String MAJOR = "일어일문학과"; // 전공
        String MAJOR_2 = "일어일문학과"; // 학과
        String PROCESS = "정규"; // 학습과정
        String SCHOOL_ID = "12341234"; // 학번
        String RESIDENT_REGISTRATION_NO = "123456789012"; // 주민번호
        String BIRTH; // 생년월일
        String SERVICE_NO = "111111"; // 군번
        int GRADE_SET = 4; // 학년제
        int SEMESTER_SET = 4; // 학기제
        int GRADE = 4; // 학년
        int COMPLETE_GRADE = 2; // 이수학기
        String NAME = "테스트이름"; // 성명
        String STATUS = "재적"; // 학적상태
        String STATUS_REASON = "테스트"; // 학적사유
        String ADDRESS = "대전광역시"; // 주소
        String CONTACT = "010-5555-5555"; // 연락처
        String PHONE_NO = "111-55-489"; // 휴대폰 번호
        String EMAIL = "ㅁㅅㅈㄷㅅ@ㅁㅁ"; // EMAIL
        String CHANGE_DT = "ㅁㅁ"; // 변동일

        NewSchoolRecordSaveRequestDto requestDto = NewSchoolRecordSaveRequestDto.builder()
                .CATEGORY(CATEGORY)
                .COLLEGE(COLLEGE)
                .MAJOR(MAJOR)
                .MAJOR_2(MAJOR_2)
                .PROCESS(PROCESS)
                .SCHOOL_ID(SCHOOL_ID)
                .RESIDENT_REGISTRATION_NO(RESIDENT_REGISTRATION_NO)
                .BIRTH(RESIDENT_REGISTRATION_NO.substring(0, 6))
                .SERVICE_NO(SERVICE_NO)
                .GRADE_SET(GRADE_SET)
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
        newSchoolRecordService.save(requestDto);

        NewSchoolRecordResponseDto data = newSchoolRecordService.findById(1L);
        System.err.println(data.getRESIDENT_REGISTRATION_NO());
        System.err.println(data.getCONTACT());
        System.err.println(data.getPHONE_NO());
    }
}
