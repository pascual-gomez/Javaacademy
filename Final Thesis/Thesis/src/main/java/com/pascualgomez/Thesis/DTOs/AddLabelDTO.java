package com.pascualgomez.Thesis.DTOs;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AddLabelDTO {

    @NotNull
    @NotBlank
    String idMessage;

    @NotNull
    @NotBlank
    String label;
}
