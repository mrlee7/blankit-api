package com.blankit.api.controller;

import com.blankit.api.controller.dto.CreateSprintRequest;
import com.blankit.api.controller.dto.CreateStudyGroupRequest;
import com.blankit.api.controller.dto.CreateTaskRequest;
import com.blankit.api.domain.entity.Sprint;
import com.blankit.api.domain.entity.Task;
import com.blankit.api.domain.service.SprintService;
import com.blankit.api.domain.service.StudyGroupService;
import com.blankit.api.domain.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/studygroup")
@RequiredArgsConstructor
public class StudyGroupController {

    private final StudyGroupService studyGroupService;

    private final SprintService sprintService;

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Long> createStudyGroup(
            @RequestBody CreateStudyGroupRequest request) {
        return ResponseEntity.ok(studyGroupService.create(request.getName()));
    }

    @PostMapping("{studyGroupId}/sprint")
    public ResponseEntity<Long> createSprint(@PathVariable Long studyGroupId,
                                             @RequestBody CreateSprintRequest request) throws Exception {
        Long saveSprintId = sprintService.create(request.getName(), studyGroupId, request.getStartAt(), request.getEndAt());
        return ResponseEntity.ok(saveSprintId);
    }

    @GetMapping("{studyGroupId}/sprint/{sprintId}")
    public ResponseEntity<Sprint> getSprint(@PathVariable Long studyGroupId,
                                               @PathVariable Long sprintId) throws Exception {
        return ResponseEntity.ok(sprintService.getOne(studyGroupId, sprintId));
    }

    @GetMapping("{studyGroupId}/sprint")
    public ResponseEntity<List<Sprint>> getSprintList(@PathVariable Long studyGroupId) {
        return ResponseEntity.ok(sprintService.getAllByStudyGroupId(studyGroupId));
    }

    @PostMapping("{studyGroupId}/sprint/{sprintId}/task")
    public ResponseEntity<Long> createTask(@PathVariable Long sprintId,
                                           @RequestBody CreateTaskRequest request) throws Exception {
        return ResponseEntity.ok(taskService.create(
                sprintId,
                request.getTitle(),
                request.getContents(),
                request.getStartDate(),
                request.getEndDate(),
                request.getDeposit(),
                request.getApproverId(),
                request.getDrafterId()));
    }

    @GetMapping("{studyGroupId}/sprint/{sprintId}/task/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable Long taskId) {
        return ResponseEntity.ok(taskService.get(taskId));
    }

    @GetMapping("{studyGroupId}/sprint/{sprintId}/task")
    public ResponseEntity<List<Task>> getTaskList(@PathVariable Long sprintId) {
        return ResponseEntity.ok(taskService.getAllBySprintId(sprintId));
    }

}
