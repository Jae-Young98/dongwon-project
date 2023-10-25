package com.hnu.dongwon.service;

import com.hnu.dongwon.dto.NewSchoolRecordResponseDto;
import com.hnu.dongwon.dto.NewSchoolRecordSaveRequestDto;
import com.hnu.dongwon.entity.NewSchoolRecord;
import com.hnu.dongwon.repository.NewSchoolRecordRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class NewSchoolRecordService {

    private final NewSchoolRecordRepository newSchoolRecordRepository;

    public Long save(NewSchoolRecordSaveRequestDto requestDto) {
        return newSchoolRecordRepository.save(requestDto.toEntity()).getID();
    }

    public NewSchoolRecordResponseDto findById (Long id) {
        NewSchoolRecord entity = newSchoolRecordRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 쿼리문이 존재하지 않습니다. id = " + id));
        return new NewSchoolRecordResponseDto(entity);
    }

    public void saveAll(Workbook workbook) throws IOException {
        List<NewSchoolRecordSaveRequestDto> requestDtoList = sheetToDB(workbook);
        for (NewSchoolRecordSaveRequestDto dto : requestDtoList) {
            newSchoolRecordRepository.save(dto.toEntity());
        }
    }

    private List<NewSchoolRecordSaveRequestDto> sheetToDB(Workbook workbook) throws IOException {
        String EXCEPT_WORDS = "[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]";
        Sheet worksheet = workbook.getSheetAt(0);
        DataFormatter formatter = new DataFormatter();

        List<NewSchoolRecordSaveRequestDto> requestDtoList = StreamSupport.stream(worksheet.spliterator(), false)
                .skip(1)
                .map(row -> {
                    String category = formatter.formatCellValue(row.getCell(0));
                    String college = formatter.formatCellValue(row.getCell(1));
                    String major = formatter.formatCellValue(row.getCell(2));
                    String major2 = formatter.formatCellValue(row.getCell(3));
                    String process = formatter.formatCellValue(row.getCell(4));
                    String schoolId = formatter.formatCellValue(row.getCell(5));
                    String resident = formatter.formatCellValue(row.getCell(6));
                    String serviceNum = formatter.formatCellValue(row.getCell(8));
                    int gradeSet = Integer.parseInt(formatter.formatCellValue(row.getCell(9)));
                    int grade = Integer.parseInt(formatter.formatCellValue(row.getCell(11)));
                    int complete = Integer.parseInt(formatter.formatCellValue(row.getCell(12)));
                    String name = formatter.formatCellValue(row.getCell(13));
                    String status = formatter.formatCellValue(row.getCell(14));
                    String statusReason = formatter.formatCellValue(row.getCell(15));
                    String address = formatter.formatCellValue(row.getCell(16));
                    String contact = formatter.formatCellValue(row.getCell(17));
                    String phoneNum = formatter.formatCellValue(row.getCell(18));
                    String email = formatter.formatCellValue(row.getCell(19));
                    String changeDate = formatter.formatCellValue(row.getCell(20));

                    return NewSchoolRecordSaveRequestDto.builder()
                            .CATEGORY(category)
                            .COLLEGE(college)
                            .MAJOR(major)
                            .MAJOR_2(major2)
                            .PROCESS(process)
                            .SCHOOL_ID(schoolId)
                            .RESIDENT_REGISTRATION_NO(resident)
                            .BIRTH(resident.substring(0, 6))
                            .SERVICE_NO(serviceNum)
                            .GRADE_SET(gradeSet)
                            .GRADE(grade)
                            .COMPLETE_GRADE(complete)
                            .NAME(name)
                            .STATUS(status)
                            .STATUS_REASON(statusReason)
                            .ADDRESS(address)
                            .CONTACT(contact.replaceAll(EXCEPT_WORDS, ""))
                            .PHONE_NO(phoneNum.replaceAll(EXCEPT_WORDS, ""))
                            .EMAIL(email)
                            .CHANGE_DT(changeDate)
                            .build();
                })
                .collect(Collectors.toList());

        workbook.close();

        return requestDtoList;
    }
}
