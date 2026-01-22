package com.global.demo.service;

import com.global.demo.domain.entity.Task;
import com.global.demo.dto.TaskCreateDTO;
import com.global.demo.dto.StatusUpdateDTO;
import com.global.demo.repository.TaskRepository;
import com.global.demo.domain.enums.Status;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    // Criar task a partir do DTO
    public Task createFromDTO(TaskCreateDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setPriority(dto.getPriority());
        return repository.save(task);
    }

    // Listar todas as tasks
    public List<Task> listAll() {
        return repository.findAll();
    }

    // Atualizar status com tratamento de erro
    public Task updateStatus(Long id, StatusUpdateDTO dto) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task não encontrada"));

        if (!isValidTransition(task.getStatus(), dto.getStatus())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Transição inválida");
        }

        task.setStatus(dto.getStatus());
        return repository.save(task);
    }

    // Validação do fluxo de status
    private boolean isValidTransition(Status current, Status next) {
        if (current == Status.TODO && next == Status.DOING) return true;
        if (current == Status.DOING && next == Status.DONE) return true;
        return false;
    }
}
