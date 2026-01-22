package com.global.demo.controller;

import com.global.demo.domain.entity.Task;
import com.global.demo.dto.TaskCreateDTO;
import com.global.demo.dto.StatusUpdateDTO;
import com.global.demo.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class ApplicationController {

    private final TaskService service;

    public ApplicationController(TaskService service) {
        this.service = service;
    }

    // Criar uma nova task via DTO
    @PostMapping
    public Task create(@RequestBody @Valid TaskCreateDTO dto) {
        return service.createFromDTO(dto);
    }

    // Listar todas as tasks
    @GetMapping
    public List<Task> listAll() {
        return service.listAll();
    }

    // Atualizar o status de uma task específica
    @PutMapping("/{id}/status")
    public Task updateStatus(@PathVariable Long id, @RequestBody StatusUpdateDTO dto) {
        return service.updateStatus(id, dto);
    }
}
