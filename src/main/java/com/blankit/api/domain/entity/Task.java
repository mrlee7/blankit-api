package com.blankit.api.domain.entity;

import com.blankit.api.domain.entity.converter.BooleanToYNConverter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TASK")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TASK_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sprint_id", foreignKey = @ForeignKey(name = "fk_sprint_task"))
    private Sprint sprint;

    @Column(nullable = false)
    private String taskTitle;

    @Column(nullable = false)
    private String taskContents;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "APPROVER_ID", foreignKey = @ForeignKey(name = "FK_TASK_APPROVER"))
    private Member approver;

    @Convert(converter = BooleanToYNConverter.class)
    @Column(nullable = false)
    private boolean isTaskSuccess;

    @Column(nullable = false)
    private int deposit;

    @ManyToOne
    @JoinColumn(name = "DRAFTER_ID", foreignKey = @ForeignKey(name = "FK_TASK_DRAFTER"))
    private Member drafter;
}

