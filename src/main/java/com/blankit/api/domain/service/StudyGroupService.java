package com.blankit.api.domain.service;

import com.blankit.api.domain.entity.StudyGroup;
import com.blankit.api.domain.repository.StudyGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudyGroupService {

    private final StudyGroupRepository studyGroupRepository;

    @Transactional
    public Long create(String name) {
        StudyGroup studyGroup = StudyGroup.builder()
                .studyGroupName(name)
                .endPoint(generateEndPoint())
                .build();
        return studyGroupRepository.save(studyGroup).getId();
    }

    // TODO: 어떻게 생성?
    private String generateEndPoint() {
        return "http://endpoint.com";
    }
}
