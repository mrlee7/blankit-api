package com.blankit.api.domain.entity;

import com.blankit.api.domain.entity.converter.BooleanToYNConverter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "MEMBER_STUDY_GROUP")
public class MemberStudyGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_STUDY_GROUP_ID")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_ID", foreignKey = @ForeignKey(name = "FK_MEMBER_MEMBERSTUDYGROUP"))
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "STUDY_GROUP_ID", foreignKey = @ForeignKey(name = "FK_STUDYGROUP_MEMBERSTUDYGROUP"))
    private StudyGroup studyGroup;

    @Convert(converter = BooleanToYNConverter.class)
    private boolean isActive;
}
