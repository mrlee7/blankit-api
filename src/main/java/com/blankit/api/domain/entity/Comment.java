package com.blankit.api.domain.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comment_id")
    private Long id;

    @Column(name = "comment_contents", nullable = false)
    private String commentContents;

    @Column(name = "created_date", nullable = false)
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(nullable = false)
    @LastModifiedDate
    private  LocalDateTime modifiedDate;
    
    @ManyToOne
    @JoinColumn(name = "member_id", foreignKey = @ForeignKey(name = "FK_COMMENT_MEMBER"))
    private Member writerId;

    @ManyToOne
    @JoinColumn(name = "task_id", foreignKey = @ForeignKey(name = "FK_COMMENT_TASK"))
    private Task task;
}
