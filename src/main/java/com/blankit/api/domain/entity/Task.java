package com.blankit.api.domain.entity;

import com.blankit.api.domain.entity.converter.BooleanToYNConverter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sprint_id", foreignKey = @ForeignKey(name = "FK_SPRINT_TASK"))
    private Sprint sprint;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "approver_id", foreignKey = @ForeignKey(name = "FK_TASK_APPROVER"))
    private Member approver;

    @Convert(converter = BooleanToYNConverter.class)
    @Column(nullable = false)
    private boolean isSuccess;

    @Column(nullable = false)
    private int deposit;

    @ManyToOne
    @JoinColumn(name = "drafter_id", foreignKey = @ForeignKey(name = "FK_TASK_DRAFTER"))
    private Member drafter;

    @Builder
    public Task(Long id, String title, String contents, LocalDateTime createdDate,
                LocalDateTime startDate, LocalDateTime endDate, Member approver, boolean isSuccess,
                int deposit, Member drafter) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.createdDate = createdDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.approver = approver;
        this.isSuccess = isSuccess;
        this.deposit = deposit;
        this.drafter = drafter;
    }

    public void updateSprint(Sprint sprint) {
        this.sprint = sprint;
        sprint.getTasks().add(this);
    }

}

