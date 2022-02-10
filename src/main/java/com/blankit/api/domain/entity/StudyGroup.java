package com.blankit.api.domain.entity;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STUDY_GROUP")
public class StudyGroup {

    @Id
    @GeneratedValue
    @Column(name = "STUDY_GROUP_ID")
    private Long id;

    @Audited
    @Column(nullable = false)
    private String studyGroupName;

    @Audited
    @Column(nullable = false)
    private String endPoint; // 스터디 그룹 초대 URL을 위해 사용

    @OneToMany(mappedBy = "studyGroup")
    private List<MemberStudyGroup> memberStudyGroups = new ArrayList<>();
}

