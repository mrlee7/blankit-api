package com.blankit.api.controller;

import com.blankit.api.controller.dto.CreateSprintRequest;
import com.blankit.api.controller.dto.CreateStudyGroupRequest;
import com.blankit.api.domain.entity.Sprint;
import com.blankit.api.domain.service.SprintService;
import com.blankit.api.domain.service.StudyGroupService;
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
    public ResponseEntity<Sprint> get(@PathVariable Long studyGroupId,
                                               @PathVariable Long sprintId) throws Exception {
        return ResponseEntity.ok(sprintService.getOne(studyGroupId, sprintId));
    }

    @GetMapping("{studyGroupId}/sprint")
    public ResponseEntity<List<Sprint>> getAll(@PathVariable Long studyGroupId) {
        return ResponseEntity.ok(sprintService.getAllByStudyGroupId(studyGroupId));
    }

}
