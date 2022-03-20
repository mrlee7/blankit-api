package com.blankit.api.domain.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "COMMMENT")
public class Comment {

    @Id
    @GeneratedValue
    @Column(name="COMMENT_ID")
    private Long id;

    @Column(name = "COMMENT_CONTENTS", nullable = false)
    private String commentContents;

    @Column(name = "CREATED_DATE", nullable = false)
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(nullable = false)
    @LastModifiedDate
    private  LocalDateTime modifiedDate;
    
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID", foreignKey = @ForeignKey(name = "FK_COMMENT_MEMBER"))
    private Member writerId;

    @ManyToOne
    @JoinColumn(name = "TASK_ID", foreignKey = @ForeignKey(name = "FK_COMMENT_TASK"))
    private Task task;
}
