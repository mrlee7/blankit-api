package com.blankit.api.studygroup.web.dto;

import com.blankit.api.studygroup.domain.StudyGroupType;
import lombok.Getter;

@Getter
public class StudyGroupRegistRequest {

    private String name;
    private StudyGroupType type;
    private String url;

    public StudyGroupRegistRequest() {
    }

    public StudyGroupRegistRequest(String name, StudyGroupType type, String url) {
        this.name = name;
        this.type = type;
        this.url = url;
    }
}
