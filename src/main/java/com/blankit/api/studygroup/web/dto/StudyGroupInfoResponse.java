package com.blankit.api.studygroup.web.dto;

import com.blankit.api.studygroup.domain.StudyGroupType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudyGroupInfoResponse {

    private String name;

    private StudyGroupType type;

    private String url;

    public StudyGroupInfoResponse(String name, StudyGroupType type, String url) {
        this.name = name;
        this.type = type;
        this.url = url;
    }

    public static StudyGroupInfoResponse of(String name, StudyGroupType type, String url) {
        return new StudyGroupInfoResponse(name, type, url);
    }

    public static StudyGroupInfoResponse empty() {
        return new StudyGroupInfoResponse();
    }
}
