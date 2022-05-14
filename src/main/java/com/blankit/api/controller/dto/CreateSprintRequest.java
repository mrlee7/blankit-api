package com.blankit.api.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateSprintRequest {

    private final String name;

    private final LocalDateTime startAt;

    private final LocalDateTime endAt;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CreateSprintRequest(@JsonProperty("name") String name,
                               @JsonProperty("startAt") LocalDateTime startAt,
                               @JsonProperty("endAt") LocalDateTime endAt) {
        this.name = name;
        this.startAt = startAt;
        this.endAt = endAt;
    }
}
