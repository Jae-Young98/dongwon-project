package com.hnu.dongwon.controller;

import com.hnu.dongwon.dto.NationalDefenseResponseDto;
import com.hnu.dongwon.dto.NationalDefenseSaveRequestDto;
import com.hnu.dongwon.dto.NationalDefenseUpdateRequestDto;
import com.hnu.dongwon.service.NationalDefenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ManageApiController {

    private final NationalDefenseService nationalDefenseService;

    @PostMapping("/nd-data")
    public Long ndSave(@RequestBody NationalDefenseSaveRequestDto requestDto) {
        return nationalDefenseService.save(requestDto);
    }

    @PutMapping("/nd-data/{id}")
    public Long ndUpdate(@PathVariable Long id, @RequestBody NationalDefenseUpdateRequestDto requestDto) {
        return nationalDefenseService.update(id, requestDto);
    }

    @DeleteMapping("/nd-data/{id}")
    public Long ndDelete(@PathVariable Long id) {
        nationalDefenseService.delete(id);
        return id;
    }

    @DeleteMapping("/nd-data/deleteSelected")
    public void ndDeleteSelected(@RequestBody List<Long> ids) {
        for (Long id : ids) {
            nationalDefenseService.delete(id);
        }
    }

    @GetMapping("/nd-data/{id}")
    public NationalDefenseResponseDto findById (@PathVariable Long id) {
        return nationalDefenseService.findById(id);
    }

}
