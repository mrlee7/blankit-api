package com.blankit.api.studygroup.service;

import com.blankit.api.studygroup.domain.StudyGroup;
import com.blankit.api.studygroup.domain.StudyGroupType;
import com.blankit.api.studygroup.domain.repository.StudyGroupRepository;
import com.blankit.api.studygroup.web.dto.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class StudyGroupServiceTest {

    @Autowired
    StudyGroupService studyGroupService;

    @Autowired
    StudyGroupRepository studyGroupRepository;

    private static final Long STUDY_GROUP_ID_1 = 1L;

    @BeforeEach
    void setUp() {
        studyGroupRepository.deleteAll();
    }

    @DisplayName("스터디 그룹 등록시 pk가 반환된다.")
    @Test
    void createStudyGroup() {
        // given
        StudyGroupRegistRequest studyGroupRegistRequest = new StudyGroupRegistRequest("TEST1", StudyGroupType.IT, "/test");

        // when
        StudyGroupRegistResponse studyGroupRegistResponse = studyGroupService.createStudyGroup(studyGroupRegistRequest);

        // then
        assertThat(studyGroupRegistResponse.getId()).isNotNull();
    }

    @DisplayName("스터디 그룹을 조회한다.")
    @Test
    void getStudyGroup() {
        // given
        StudyGroup studyGroup = StudyGroup.builder()
            .name("Group1")
            .studyGroupType(StudyGroupType.IT)
            .build();
        studyGroupRepository.save(studyGroup);

        // when
        StudyGroupInfoResponse response = studyGroupService.getStudyGroup(studyGroup.getId());

        // then
        assertThat(response.getName()).isEqualTo(studyGroup.getName());
        assertThat(response.getType()).isEqualTo(studyGroup.getStudyGroupType());
        assertThat(response.getUrl()).isEqualTo(studyGroup.getUrl());
    }

    @DisplayName("스터디 그룹 목록을 조회한다.")
    @Test
    void getStudyGroups() {
        // given
        StudyGroup studyGroup1 = StudyGroup.builder()
            .name("Group1")
            .studyGroupType(StudyGroupType.IT)
            .build();

        StudyGroup studyGroup2 = StudyGroup.builder()
            .name("Group2")
            .studyGroupType(StudyGroupType.IT)
            .build();

        studyGroupRepository.saveAll(List.of(studyGroup1, studyGroup2));

        // when
        List<StudyGroupInfoResponse> studyGroups = studyGroupService.getAllStudyGroups();

        // then
        assertThat(studyGroups.size()).isEqualTo(2);
    }

    @DisplayName("스터디 그룹 정보를 수정한다.")
    @Test
    void modifyStudyGroup() {
        // given
        String changedUrl = "/test1";
        StudyGroup studyGroup = StudyGroup.builder()
            .name("modifyGroup1")
            .studyGroupType(StudyGroupType.MARKETING)
            .build();
        studyGroupRepository.save(studyGroup);
        String changeName = "modifyGroup2";

        // when
        StudyGroupModifyRequest studyGroupModifyRequest = new StudyGroupModifyRequest(changeName, StudyGroupType.IT, changedUrl);
        StudyGroupModifyResponse studyGroupModifyResponse = studyGroupService.modifyStudyGroup(studyGroup.getId(), studyGroupModifyRequest);

        // then
        assertThat(studyGroupModifyResponse.getStatus()).isEqualTo("true");
    }
}