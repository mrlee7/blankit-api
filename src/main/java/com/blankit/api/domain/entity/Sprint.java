package com.blankit.api.domain.entity;

import com.blankit.api.domain.model.SprintPeriod;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Sprint {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SPRINT_ID")
    private Long id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_group_id", foreignKey = @ForeignKey(name = "fk_studygroup_sprint"))
    private StudyGroup studyGroup;

    @OneToMany(mappedBy = "sprint")
    private List<Task> tasks = new ArrayList<>();

    @Embedded
    private SprintPeriod sprintPeriod;

    @Builder
    public Sprint(Long id, String name, SprintPeriod sprintPeriod) {
        this.id = id;
        this.name = name;
        this.sprintPeriod = sprintPeriod;
    }

    public void updateStudyGroup(StudyGroup studyGroup) {
        this.studyGroup = studyGroup;
        studyGroup.getSprints().add(this);
    }

}
