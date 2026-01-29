package com.global.demo.dto;

import com.global.demo.domain.enums.Priority;
import com.global.demo.domain.enums.Status;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO de resposta de uma task")
public class TaskResponseDTO {

    @Schema(description = "ID da task", example = "1")
    private Long id;

    @Schema(description = "Título da task", example = "Implementar API")
    private String title;

    @Schema(description = "Descrição da task", example = "Criar endpoints REST para tasks")
    private String description;

    @Schema(description = "Status da task", example = "PENDING")
    private Status status;

    @Schema(description = "Prioridade da task", example = "HIGH")
    private Priority priority;

    @Schema(description = "Data de criação da task")
    private LocalDateTime createdAt;

    public TaskResponseDTO(Long id, String title, String description,
                           Status status, Priority priority, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
