package com.ladyFlow.menstrualCycleApp.data.dto;

import com.ladyFlow.menstrualCycleApp.data.models.MonthlyCycle;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PeriodDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nextFlowDate;
    private String ovulationDate;
    private String SafePeriod;
    private String fertilePeriod;

    public LocalDate getNextFlowDateAsLocalDate(MonthlyCycle monthlyCycle) {
        LocalDate startDate = monthlyCycle.getStartDate();
        int cycleLength = monthlyCycle.getCycleLength();
        return startDate.plusDays(cycleLength);
    }
}
