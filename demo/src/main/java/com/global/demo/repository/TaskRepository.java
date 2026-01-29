package com.global.demo.repository;

import com.global.demo.domain.entity.Task;
import com.global.demo.domain.enums.Priority;
import com.global.demo.domain.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    // Filtros simples
    List<Task> findByStatus(Status status);
    List<Task> findByPriority(Priority priority);
    List<Task> findByStatusAndPriority(Status status, Priority priority);

    // Paginação e ordenação
    Page<Task> findAll(Pageable pageable);
}
