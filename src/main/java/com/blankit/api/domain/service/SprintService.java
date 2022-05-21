package com.blankit.api.domain.service;

import com.blankit.api.domain.entity.Sprint;
import com.blankit.api.domain.entity.StudyGroup;
import com.blankit.api.domain.model.SprintPeriod;
import com.blankit.api.domain.repository.sprint.SprintRepository;
import com.blankit.api.domain.repository.StudyGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SprintService {

    private final SprintRepository sprintRepository;

    private final StudyGroupRepository studyGroupRepository;

    public Long create(String name, Long studyGroupId, LocalDateTime startAt, LocalDateTime endAt) throws Exception {

        StudyGroup studyGroup = studyGroupRepository.findById(studyGroupId).orElseThrow(() -> new Exception("스터디 그룹 없음"));

        Sprint sprint = Sprint.builder()
                .name(name)
                .sprintPeriod(SprintPeriod.of(startAt, endAt))
                .build();

        sprint.updateStudyGroup(studyGroup);

        return sprintRepository.save(sprint).getId();
    }

    @Transactional(readOnly = true)
    public Sprint getOne(Long studyGroupId, Long sprintId) throws Exception {
        return sprintRepository
                .findBySprintIdAndStudyGroupId(sprintId, studyGroupId)
                .orElseThrow(Exception::new);
    }

    @Transactional(readOnly = true)
    public List<Sprint> getAllByStudyGroupId(Long studyGroupId) {
        return sprintRepository.findAllByStudyGroupId(studyGroupId);
    }

}
