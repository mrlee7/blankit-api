package com.blankit.api.studygroup.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudyGroupModifyResponse {

    private String status;

    private StudyGroupModifyResponse(String status) {
        this.status = status;
    }

    public static StudyGroupModifyResponse of() {
        return new StudyGroupModifyResponse("true");
    }
}
