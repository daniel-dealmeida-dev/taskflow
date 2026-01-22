package com.global.demo.dto;

import com.global.demo.domain.enums.Priority;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TaskCreateDTO {

    @NotNull
    @Size(min = 3, max = 50)
    private String title;

    private String description;

    private Priority priority;

    // GETTERS E SETTERS
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
