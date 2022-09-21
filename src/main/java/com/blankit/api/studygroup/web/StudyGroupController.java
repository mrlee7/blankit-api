package com.blankit.api.studygroup.web;

import com.blankit.api.studygroup.service.StudyGroupService;
import com.blankit.api.studygroup.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/studygroup")
public class StudyGroupController {

    private final StudyGroupService studyGroupService;

    @PostMapping
    public ResponseEntity<StudyGroupRegistResponse> createStudyGroup(@RequestBody StudyGroupRegistRequest request) {
        StudyGroupRegistResponse studyGroupRegistResponse = studyGroupService.createStudyGroup(request);
        return ResponseEntity.ok(studyGroupRegistResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudyGroupInfoResponse> findStudyGroup(@PathVariable Long id) {
        return ResponseEntity.ok(studyGroupService.getStudyGroup(id));
    }

    @GetMapping
    public ResponseEntity<List<StudyGroupInfoResponse>> findAllStudyGroup() {
        return ResponseEntity.ok(studyGroupService.getAllStudyGroups());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudyGroupModifyResponse> modifyStudyGroup(@PathVariable Long id, @RequestBody StudyGroupModifyRequest request) {
        StudyGroupModifyResponse studyGroupModifyResponse = studyGroupService.modifyStudyGroup(id, request);
        return ResponseEntity.ok(studyGroupModifyResponse);
    }
}
