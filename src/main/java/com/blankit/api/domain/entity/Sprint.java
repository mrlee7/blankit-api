package com.blankit.api.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sprint {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SPRINT_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_group_id", foreignKey = @ForeignKey(name = "fk_studygroup_sprint"))
    private StudyGroup studyGroup;

    @OneToMany(mappedBy = "sprint")
    private List<Task> tasks = new ArrayList<>();

    @Column(nullable = false)
    private LocalDateTime startAt;

    @Column(nullable = false)
    private LocalDateTime endAt;

}
