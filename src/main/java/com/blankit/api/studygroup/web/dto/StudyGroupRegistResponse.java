package com.blankit.api.studygroup.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudyGroupRegistResponse {

    private Long id;

    private StudyGroupRegistResponse(Long id) {
        this.id = id;
    }

    public static StudyGroupRegistResponse of(Long id) {
        return new StudyGroupRegistResponse(id);
    }
}
