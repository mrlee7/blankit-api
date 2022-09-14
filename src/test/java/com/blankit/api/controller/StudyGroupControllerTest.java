package com.blankit.api.controller;

import com.blankit.api.studygroup.domain.StudyGroupType;
import com.blankit.api.studygroup.service.StudyGroupService;
import com.blankit.api.studygroup.web.dto.StudyGroupInfoResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class StudyGroupControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudyGroupService studyGroupService;

    private static final Long STUDY_GROUP_RESPONSE_ID_1 = 1L;
    private static final StudyGroupInfoResponse STUDY_GROUP_RESPONSE_1 = new StudyGroupInfoResponse(
        "name1",
        StudyGroupType.IT,
        "/test1"
    );

    private static final StudyGroupInfoResponse STUDY_GROUP_RESPONSE_2 = new StudyGroupInfoResponse(
        "name2",
        StudyGroupType.MARKETING,
        "/test2"
    );

    @Test
    void createStudyGroup() throws Exception {
        mockMvc.perform(post("/studygroup")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"\", \"content\": \"\"}")
        );
    }

    @DisplayName("스터디그룹을 단건 조회한다.")
    @Test
    void getStudyGroup() throws Exception {
        // given & when
        given(studyGroupService.getStudyGroup(STUDY_GROUP_RESPONSE_ID_1)).willReturn(STUDY_GROUP_RESPONSE_1);

        // then
        mockMvc.perform(get("/studygroup/{id}", STUDY_GROUP_RESPONSE_ID_1)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.name").value("name1"))
            .andExpect(jsonPath("$.type").value("IT"))
            .andExpect(jsonPath("$.url").value("/test1"))
            .andExpect(status().isOk());
    }

    @DisplayName("스터디그룹을 여러개 조회한다.")
    @Test
    void getStudyGroups() throws Exception {
        // given & when
        List<StudyGroupInfoResponse> studyGroupInfoResponseList = List.of(STUDY_GROUP_RESPONSE_1, STUDY_GROUP_RESPONSE_2);
        given(studyGroupService.getAllStudyGroups()).willReturn(studyGroupInfoResponseList);

        // expected
        mockMvc.perform(get("/studygroup")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].name").value("name1"))
            .andExpect(jsonPath("$[0].type").value("IT"))
            .andExpect(jsonPath("$[0].url").value("/test1"))
            .andExpect(jsonPath("$[1].name").value("name2"))
            .andExpect(jsonPath("$[1].type").value("MARKETING"))
            .andExpect(jsonPath("$[1].url").value("/test2"))
            .andDo(print());
    }
}