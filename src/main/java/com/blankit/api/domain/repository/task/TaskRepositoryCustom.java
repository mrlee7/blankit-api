package com.blankit.api.domain.repository.task;

import com.blankit.api.domain.entity.Task;

import java.util.List;

public interface TaskRepositoryCustom {
    List<Task> findAllBySprintId(Long sprintId);
}
