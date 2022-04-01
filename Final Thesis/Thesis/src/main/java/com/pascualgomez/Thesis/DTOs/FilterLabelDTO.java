package com.pascualgomez.Thesis.DTOs;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class FilterLabelDTO {
    @NotNull
    private String label;
}
