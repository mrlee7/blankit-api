package com.blankit.api.domain.service;

import com.blankit.api.controller.dto.CreateSprintRequest;
import com.blankit.api.domain.entity.StudyGroup;
import com.blankit.api.domain.repository.StudyGroupRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SprintServiceTest {

    @Autowired SprintService sprintService;
    @Autowired StudyGroupRepository studyGroupRepository;


    @BeforeEach
    void setup() {
        Long studyGroupId = 1L;
        StudyGroup studyGroup = StudyGroup.builder()
                .id(studyGroupId)
                .endPoint("http://invite.com")
                .studyGroupName("study_group_01")
                .build();
        studyGroupRepository.save(studyGroup);
    }

    @Test
    void create_sprint() throws Exception {
        // given
        LocalDateTime now = LocalDateTime.now();
        CreateSprintRequest request = new CreateSprintRequest("TEST01", now, now.plusDays(7));
        Long studyGroupId = 1L;

        // when
        Long id = sprintService.create(request.getName(), studyGroupId, request.getStartAt(), request.getEndAt());

        // then
        assertThat(id).isNotNull();
    }

}