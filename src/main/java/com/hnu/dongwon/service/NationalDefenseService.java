package com.hnu.dongwon.service;

import com.hnu.dongwon.dto.NationalDefenseListResponseDto;
import com.hnu.dongwon.dto.NationalDefenseResponseDto;
import com.hnu.dongwon.dto.NationalDefenseSaveRequestDto;
import com.hnu.dongwon.dto.NationalDefenseUpdateRequestDto;
import com.hnu.dongwon.entity.NationalDefense;
import com.hnu.dongwon.repository.ManageNationalDefenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NationalDefenseService {

    private final ManageNationalDefenseRepository manageNationalDefenseRepository;

    @Transactional(readOnly = true)
    public List<NationalDefenseListResponseDto> findAllAsc() {
        return manageNationalDefenseRepository.findAllAsc().stream()
                .map(NationalDefenseListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long save(NationalDefenseSaveRequestDto requestDto) {
        return manageNationalDefenseRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, NationalDefenseUpdateRequestDto requestDto) {
        NationalDefense nationalDefense = manageNationalDefenseRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 쿼리문이 존재하지 않습니다. id = " + id));
        nationalDefense.update(requestDto.getName(), requestDto.getQuery(), requestDto.getDescription(), requestDto.getOthers());

        return id;
    }

    public NationalDefenseResponseDto findById (Long id) {
        NationalDefense entity = manageNationalDefenseRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 쿼리문이 존재하지 않습니다. id = " + id));
        return new NationalDefenseResponseDto(entity);
    }

    public NationalDefenseResponseDto findByName (String name) {
        NationalDefense entity = manageNationalDefenseRepository.findByName(name);

        return new NationalDefenseResponseDto(entity);
    }
}
