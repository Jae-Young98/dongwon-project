package com.hnu.dongwon.controller;

import com.hnu.dongwon.dto.WorkManageResponseDto;
import com.hnu.dongwon.dto.WorkManageSaveRequestDto;
import com.hnu.dongwon.dto.WorkManageUpdateRequestDto;
import com.hnu.dongwon.service.WorkManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ManageApiController {

    private final WorkManageService workManageService;

    @PostMapping("/insert-data")
    public Long ndSave(@RequestBody WorkManageSaveRequestDto requestDto) {
        return workManageService.save(requestDto);
    }

    @PutMapping("/update-data/{id}")
    public Long ndUpdate(@PathVariable Long id, @RequestBody WorkManageUpdateRequestDto requestDto) {
        return workManageService.update(id, requestDto);
    }

    @DeleteMapping("/delete-data/{id}")
    public Long ndDelete(@PathVariable Long id) {
        workManageService.delete(id);
        return id;
    }

    @DeleteMapping("/delete-data/selected")
    public void ndDeleteSelected(@RequestBody List<Long> ids) {
        for (Long id : ids) {
            workManageService.delete(id);
        }
    }

    @GetMapping("/data/{id}")
    public WorkManageResponseDto findById (@PathVariable Long id) {
        return workManageService.findById(id);
    }


}
