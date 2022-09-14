package com.blankit.api.studygroup.domain.repository;

import com.blankit.api.studygroup.domain.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyGroupRepository extends JpaRepository<StudyGroup, Long> {
}
