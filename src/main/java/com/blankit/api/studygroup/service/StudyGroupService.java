package com.blankit.api.studygroup.service;

import com.blankit.api.studygroup.domain.StudyGroup;
import com.blankit.api.studygroup.domain.repository.StudyGroupRepository;
import com.blankit.api.studygroup.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudyGroupService {

    private final StudyGroupRepository studyGroupRepository;

    @Transactional
    public StudyGroupRegistResponse createStudyGroup(StudyGroupRegistRequest request) {
        StudyGroup studyGroup = StudyGroup.builder()
            .name(request.getName())
            .studyGroupType(request.getType())
            .build();
        return StudyGroupRegistResponse.of(studyGroupRepository.save(studyGroup).getId());
    }

    public StudyGroupInfoResponse getStudyGroup(Long id) {
        return studyGroupRepository.findById(id)
            .map(studyGroup -> StudyGroupInfoResponse.of(studyGroup.getName(), studyGroup.getStudyGroupType(), studyGroup.getUrl()))
            .orElseGet(StudyGroupInfoResponse::empty);
    }

    public List<StudyGroupInfoResponse> getAllStudyGroups() {
        return studyGroupRepository.findAll().stream()
            .map(studyGroup -> StudyGroupInfoResponse.of(studyGroup.getName(), studyGroup.getStudyGroupType(), studyGroup.getUrl()))
            .collect(Collectors.toList());
    }

    @Transactional
    public StudyGroupModifyResponse modifyStudyGroup(Long id, StudyGroupModifyRequest request) {
        StudyGroup studyGroup = studyGroupRepository.findById(id).get();
        studyGroup.modifyInfo(request.getName(), request.getType(), request.getUrl());
        return StudyGroupModifyResponse.of();
    }
}
