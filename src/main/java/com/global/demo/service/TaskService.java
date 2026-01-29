package com.global.demo.service;

import com.global.demo.domain.entity.Task;
import com.global.demo.domain.enums.Priority;
import com.global.demo.domain.enums.Status;
import com.global.demo.dto.TaskCreateDTO;
import com.global.demo.dto.TaskResponseDTO;
import com.global.demo.dto.StatusUpdateDTO;
import com.global.demo.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    // Criar task
    public TaskResponseDTO createFromDTO(TaskCreateDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setPriority(dto.getPriority());
        Task saved = repository.save(task);
        return toResponseDTO(saved);
    }

    // Listar todas
    public List<Task> listAll() {
        return repository.findAll();
    }

    // Atualizar status
    public TaskResponseDTO updateStatus(Long id, StatusUpdateDTO dto) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task não encontrada"));

        if (!isValidTransition(task.getStatus(), dto.getStatus())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Transição inválida");
        }

        task.setStatus(dto.getStatus());
        Task updated = repository.save(task);
        return toResponseDTO(updated);
    }

    // Deletar
    public void delete(Long id) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task não encontrada"));
        repository.delete(task);
    }

    // Filtro simples
    public List<TaskResponseDTO> filterTasks(Status status, Priority priority) {
        List<Task> tasks;
        if (status != null && priority != null) {
            tasks = repository.findByStatusAndPriority(status, priority);
        } else if (status != null) {
            tasks = repository.findByStatus(status);
        } else if (priority != null) {
            tasks = repository.findByPriority(priority);
        } else {
            tasks = repository.findAll();
        }
        return tasks.stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    // Paginação e ordenação
    public Page<TaskResponseDTO> listPaginated(Pageable pageable) {
        return repository.findAll(pageable)
                .map(this::toResponseDTO);
    }

    // Converter para DTO
    public TaskResponseDTO toResponseDTO(Task task) {
        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getPriority(),
                task.getCreatedAt()
        );
    }

    // Validação do fluxo de status
    private boolean isValidTransition(Status current, Status next) {
        if (current == Status.TODO && next == Status.DOING) return true;
        if (current == Status.DOING && next == Status.DONE) return true;
        return false;
    }
}
