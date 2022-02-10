package com.blankit.api.domain.entity;

import com.blankit.api.domain.entity.converter.BooleanToYNConverter;
import org.hibernate.envers.Audited;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "MEMBER_STUDY_GROUP")
public class MemberStudyGroup {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_STUDY_GROUP_ID")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_ID", foreignKey = @ForeignKey(name = "FK_MEMBER_MEMBER_STUDY_GROUP"))
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "STUDY_GROUP_ID", foreignKey = @ForeignKey(name = "FK_STUDY_GROUP_MEMBER_STUDY_GROUP"))
    private StudyGroup studyGroup;

    @Convert(converter = BooleanToYNConverter.class)
    @Audited
    private boolean isActive;
}
