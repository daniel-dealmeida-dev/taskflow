package com.global.demo.dto;

import com.global.demo.domain.enums.Priority;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para criar uma nova task")
public class TaskCreateDTO {

    @NotNull
    @Size(min = 3, max = 50)
    @Schema(description = "Título da task", example = "Implementar API", required = true)
    private String title;

    @Schema(description = "Descrição detalhada da task", example = "Criar endpoints REST para tasks")
    private String description;

    @Schema(description = "Prioridade da task", example = "HIGH")
    private Priority priority;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }
}
