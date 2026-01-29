package com.global.demo.dto;

import com.global.demo.domain.enums.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "DTO para atualizar o status de uma task")
public class StatusUpdateDTO {

    @NotNull
    @Schema(description = "Novo status da task", example = "IN_PROGRESS", required = true)
    private Status status;

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
