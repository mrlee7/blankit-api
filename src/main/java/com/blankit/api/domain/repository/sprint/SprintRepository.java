package com.blankit.api.domain.repository.sprint;

import com.blankit.api.domain.entity.Sprint;
import com.blankit.api.domain.repository.sprint.SprintRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintRepository extends JpaRepository<Sprint, Long>, SprintRepositoryCustom {



}
