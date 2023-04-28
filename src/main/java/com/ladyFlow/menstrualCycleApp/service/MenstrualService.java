package com.ladyFlow.menstrualCycleApp.service;

import com.ladyFlow.menstrualCycleApp.data.dto.PeriodDto;
import com.ladyFlow.menstrualCycleApp.data.models.MonthlyCycle;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenstrualService {
    public PeriodDto calculateOvulation(MonthlyCycle monthlyCycle) {
        LocalDate startDate = monthlyCycle.getStartDate();
        int cycleLength = monthlyCycle.getCycleLength();
        if (startDate == null) {
            PeriodDto periodDto = new PeriodDto();
            periodDto.setNextFlowDate(null);
            periodDto.setOvulationDate(null);
            periodDto.setSafePeriod(null);
            periodDto.setFertilePeriod(null);
            return periodDto;
        }
        LocalDate nextFlowDate = startDate.plusDays(cycleLength);
        LocalDate ovulationDate = startDate.plusDays(cycleLength - 14);
        LocalDate safePeriod = startDate.plusDays(cycleLength - 12);
        LocalDate fertilePeriod = startDate.plusDays(cycleLength - 11);


        PeriodDto periodDto = new PeriodDto();
        periodDto.setNextFlowDate(nextFlowDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        periodDto.setFertilePeriod(fertilePeriod.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        periodDto.setOvulationDate(ovulationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        periodDto.setSafePeriod(safePeriod.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        return periodDto;
    }

    public List <PeriodDto> yearCalculation(MonthlyCycle monthlyCycle) {
        List <PeriodDto> periodDtoList = new ArrayList<>();
        int cycleLength = monthlyCycle.getCycleLength();
        for (int i = 0; i < 12; i++) {
            LocalDate startDate = monthlyCycle.getStartDate().plusDays((long) cycleLength * i);
            monthlyCycle.setStartDate(startDate);
            PeriodDto currentMonthResult = calculateOvulation(monthlyCycle);
            periodDtoList.add(currentMonthResult);
        }
//        PeriodDto currentMonthResult = calculateOvulation(monthlyCycle);
//        periodDtoList.add(currentMonthResult);
//        LocalDate nextFlowDate = currentMonthResult.getNextFlowDateAsLocalDate(monthlyCycle);
//        for (int i = 1; i < 12; i++) {
//            if (nextFlowDate == null) {
//                break;
//            }
//            nextFlowDate = nextFlowDate.plusDays(cycleLength);
//            PeriodDto periodDto = calculateOvulation(new MonthlyCycle(nextFlowDate, cycleLength));
//            periodDtoList.add(periodDto);
//        }
        return periodDtoList;
    }


    public static void main(String[] args) {
        MenstrualService menstrualService = new MenstrualService();
        int day = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter day: "));
        int month = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter month: "));
        int year = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter year: "));
        int cycle = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter cycle: "));
        JOptionPane.showMessageDialog(null, "Your next start date is: " + menstrualService);
    }
}
