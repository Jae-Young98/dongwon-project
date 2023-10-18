package com.hnu.dongwon.service;

import com.hnu.dongwon.dto.WorkManageListResponseDto;
import com.hnu.dongwon.dto.WorkManageResponseDto;
import com.hnu.dongwon.dto.WorkManageSaveRequestDto;
import com.hnu.dongwon.dto.WorkManageUpdateRequestDto;
import com.hnu.dongwon.entity.WorkManage;
import com.hnu.dongwon.repository.WorkManageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WorkManageService {

    private final WorkManageRepository workManageRepository;

    @Transactional(readOnly = true)
    public List<WorkManageListResponseDto> findAllAsc() {
        return workManageRepository.findAllAsc().stream()
                .map(WorkManageListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<WorkManageListResponseDto> findWorkAsc(String work) {
        return workManageRepository.findByWorkASC(work).stream()
                .map(WorkManageListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<WorkManageListResponseDto> findByWorkIs(String work) {
        return workManageRepository.findByWorkIs(work).stream()
                .map(WorkManageListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<WorkManageListResponseDto> findByCategoryCostAsc(String category) {
        return workManageRepository.findByCategoryCostAsc(category).stream()
                .map(WorkManageListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long save(WorkManageSaveRequestDto requestDto) {
        return workManageRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, WorkManageUpdateRequestDto requestDto) {
        WorkManage workManage = workManageRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 업무가 존재하지 않습니다. id = " + id));
        workManage.update(requestDto.getType(), requestDto.getOrderCost(), requestDto.getName(), requestDto.getQuery(), requestDto.getDescription(), requestDto.getOthers());

        return id;
    }

    @Transactional
    public void delete(Long id) {
        WorkManage workManage = workManageRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 업무가 존재하지 않습니다. id = " + id));
        workManageRepository.delete(workManage);
    }

    public WorkManageResponseDto findById (Long id) {
        WorkManage entity = workManageRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 쿼리문이 존재하지 않습니다. id = " + id));
        return new WorkManageResponseDto(entity);
    }

    public WorkManageResponseDto findByName (String name) {
        WorkManage entity = workManageRepository.findByName(name);

        return new WorkManageResponseDto(entity);
    }

    public WorkManageResponseDto findByCategory (String category) {
        WorkManage entity = workManageRepository.findByCategory(category);

        return new WorkManageResponseDto(entity);
    }
}
