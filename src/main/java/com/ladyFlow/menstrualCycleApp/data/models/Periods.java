package com.ladyFlow.menstrualCycleApp.data.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Periods {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private LocalDate nextFlowDate;
    private LocalDate ovulationDate;
    private LocalDate SafePeriod;
    private LocalDate fertilePeriod;
}
