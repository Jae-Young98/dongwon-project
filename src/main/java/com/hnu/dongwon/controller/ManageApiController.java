package com.hnu.dongwon.controller;

import com.hnu.dongwon.dto.NationalDefenseResponseDto;
import com.hnu.dongwon.dto.NationalDefenseSaveRequestDto;
import com.hnu.dongwon.dto.NationalDefenseUpdateRequestDto;
import com.hnu.dongwon.service.NationalDefenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public Long naUpdate(@PathVariable Long id, @RequestBody NationalDefenseUpdateRequestDto requestDto) {
        return nationalDefenseService.update(id, requestDto);
    }

    @GetMapping("/nd-data/{id}")
    public NationalDefenseResponseDto findById (@PathVariable Long id) {
        return nationalDefenseService.findById(id);
    }

}
