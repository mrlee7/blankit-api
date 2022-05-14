package com.blankit.api.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "STUDY_GROUP")
public class StudyGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDY_GROUP_ID")
    private Long id;

    @Column(nullable = false)
    private String studyGroupName;

    @Column(nullable = false)
    private String endPoint; // 스터디 그룹 초대 URL을 위해 사용

    @OneToMany(mappedBy = "studyGroup")
    private List<MemberStudyGroup> memberStudyGroups = new ArrayList<>();

    @OneToMany(mappedBy = "studyGroup")
    private List<Sprint> sprints = new ArrayList<>();

    @Builder
    public StudyGroup(Long id, String studyGroupName, String endPoint, List<MemberStudyGroup> memberStudyGroups, List<Sprint> sprints) {
        this.id = id;
        this.studyGroupName = studyGroupName;
        this.endPoint = endPoint;
        this.memberStudyGroups = memberStudyGroups;
        this.sprints = sprints;
    }
}

