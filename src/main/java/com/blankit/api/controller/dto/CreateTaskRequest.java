package com.blankit.api.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateTaskRequest {

    private final Long sprintId;

    private final String title;

    private final String contents;

    private final LocalDateTime startDate;

    private final LocalDateTime endDate;

    private final int deposit;

    private final Long approverId;

    private final Long drafterId;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CreateTaskRequest(@JsonProperty("sprintId") Long sprintId,
                             @JsonProperty("title") String title,
                             @JsonProperty("contents") String contents,
                             @JsonProperty("startDate") LocalDateTime startDate,
                             @JsonProperty("endDate") LocalDateTime endDate,
                             @JsonProperty("deposit") int deposit,
                             @JsonProperty("approverId") Long approverId,
                             @JsonProperty("drafterId") Long drafterId) {
        this.sprintId = sprintId;
        this.title = title;
        this.contents = contents;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.approverId = approverId;
        this.drafterId = drafterId;
    }
}
