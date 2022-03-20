package com.blankit.api.domain.entity;

import com.blankit.api.domain.entity.converter.BooleanToYNConverter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TASK")
public class Task {

    @Id
    @GeneratedValue
    @Column(name = "TASK_ID")
    private Long id;

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
    @JoinColumn(name = "MEMBER_ID", foreignKey = @ForeignKey(name = "FK_TASK_MEMBER"))
    private Member approverId;

    @Convert(converter = BooleanToYNConverter.class)
    @Column(nullable = false)
    private boolean isTaskSuccess;

    @Column(nullable = false)
    private int deposit;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID", foreignKey = @ForeignKey(name = "FK_TASK_MEMBER"))
    private Member drafterId;
}

