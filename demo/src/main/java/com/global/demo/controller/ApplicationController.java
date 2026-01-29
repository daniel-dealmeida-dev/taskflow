package com.global.demo.controller;

import com.global.demo.dto.TaskCreateDTO;
import com.global.demo.dto.TaskResponseDTO;
import com.global.demo.dto.StatusUpdateDTO;
import com.global.demo.domain.enums.Priority;
import com.global.demo.domain.enums.Status;
import com.global.demo.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class ApplicationController {

    private final TaskService service;

    public ApplicationController(TaskService service) {
        this.service = service;
    }

    @Operation(summary = "Cria uma nova task",
               responses = {
                   @ApiResponse(responseCode = "201", description = "Task criada com sucesso",
                                content = @Content(schema = @Schema(implementation = TaskResponseDTO.class))),
                   @ApiResponse(responseCode = "400", description = "Dados inválidos")
               })
    @PostMapping
    public ResponseEntity<TaskResponseDTO> create(@RequestBody @Valid TaskCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createFromDTO(dto));
    }

    @Operation(summary = "Lista todas as tasks")
    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> listAll() {
        List<TaskResponseDTO> tasks = service.listAll()
                .stream()
                .map(service::toResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tasks);
    }

    @Operation(summary = "Atualiza o status de uma task",
               responses = {
                   @ApiResponse(responseCode = "200", description = "Status atualizado",
                                content = @Content(schema = @Schema(implementation = TaskResponseDTO.class))),
                   @ApiResponse(responseCode = "404", description = "Task não encontrada")
               })
    @PutMapping("/{id}/status")
    public ResponseEntity<TaskResponseDTO> updateStatus(
            @Parameter(description = "ID da task") @PathVariable Long id,
            @RequestBody @Valid StatusUpdateDTO dto) {
        return ResponseEntity.ok(service.updateStatus(id, dto));
    }

    @Operation(summary = "Deleta uma task",
               responses = {
                   @ApiResponse(responseCode = "204", description = "Task deletada"),
                   @ApiResponse(responseCode = "404", description = "Task não encontrada")
               })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Parameter(description = "ID da task") @PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Filtra tasks por status e prioridade")
    @GetMapping("/filter")
    public ResponseEntity<List<TaskResponseDTO>> filter(
            @Parameter(description = "Status da task") @RequestParam(required = false) Status status,
            @Parameter(description = "Prioridade da task") @RequestParam(required = false) Priority priority) {
        return ResponseEntity.ok(service.filterTasks(status, priority));
    }

    @Operation(summary = "Lista tasks paginadas")
    @GetMapping("/page")
    public ResponseEntity<Page<TaskResponseDTO>> listPaginated(Pageable pageable) {
        return ResponseEntity.ok(service.listPaginated(pageable));
    }
}
