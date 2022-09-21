package com.blankit.api.studygroup.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class StudyGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private StudyGroupType studyGroupType;

    private String url;

    public void modifyInfo(String name, StudyGroupType studyGroupType, String url) {
        this.name = name;
        this.studyGroupType = studyGroupType;
        this.url = url;
    }

    public StudyGroup() {
    }

    @Builder
    public StudyGroup(Long id, String name, StudyGroupType studyGroupType, String url) {
        this.id = id;
        this.name = name;
        this.studyGroupType = studyGroupType;
        this.url = url;
    }
}
