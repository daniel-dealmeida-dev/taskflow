package com.global.demo.dto;

import com.global.demo.domain.enums.Status;

public class StatusUpdateDTO {

    private Status status;

    public StatusUpdateDTO() {}

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
