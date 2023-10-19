package com.hnu.dongwon.service;

import com.hnu.dongwon.dto.NewSchoolRecordResponseDto;
import com.hnu.dongwon.dto.NewSchoolRecordSaveRequestDto;
import com.hnu.dongwon.entity.NewSchoolRecord;
import com.hnu.dongwon.repository.NewSchoolRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
