package com.ladyFlow.menstrualCycleApp.controller;

import com.ladyFlow.menstrualCycleApp.data.dto.PeriodDto;
import com.ladyFlow.menstrualCycleApp.data.models.MonthlyCycle;
import com.ladyFlow.menstrualCycleApp.service.MenstrualService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class MenstrualController {
    public final MenstrualService menstrualService;

    @PostMapping("/ovulation")
    public PeriodDto getOvulation(@RequestBody MonthlyCycle monthlyCycle) {
        return menstrualService.calculateOvulation(monthlyCycle);
    }

    @PostMapping("/ovulationYear")
    public List <PeriodDto> getOvulationYear(@RequestBody MonthlyCycle monthlyCycle) {
        List <PeriodDto> periodDtoList = menstrualService.yearCalculation(monthlyCycle);
        return periodDtoList;
    }
}
