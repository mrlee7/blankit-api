package com.blankit.api.domain.entity;

import com.blankit.api.domain.entity.converter.BooleanToYNConverter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "member_study_group")
public class MemberStudyGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_study_group_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id", foreignKey = @ForeignKey(name = "FK_MEMBER_MEMBERSTUDYGROUP"))
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "study_group_id", foreignKey = @ForeignKey(name = "FK_STUDYGROUP_MEMBERSTUDYGROUP"))
    private StudyGroup studyGroup;

    @Convert(converter = BooleanToYNConverter.class)
    private boolean isActive;
}
