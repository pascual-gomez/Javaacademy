package com.pascualgomez.Thesis.DTOs;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
public class SendMessageDTO {
    @NotEmpty
    @NotNull
    private String subject;

    private String body;
    private String attachment;

    @NotEmpty
    @NotNull
    private List<String> sendTo;

    private List<String> sendCopy;
    private List<String> sendBlindCopy;
}

