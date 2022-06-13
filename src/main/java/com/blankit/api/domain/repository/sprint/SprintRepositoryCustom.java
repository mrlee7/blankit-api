package com.blankit.api.domain.repository.sprint;

import com.blankit.api.domain.entity.Sprint;

import java.util.List;
import java.util.Optional;

public interface SprintRepositoryCustom {

    Optional<Sprint> findBySprintIdAndStudyGroupId(Long sprintId, Long studyGroupId);

    List<Sprint> findAllByStudyGroupId(Long studyGroupId);

}
