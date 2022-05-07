package com.blankit.api.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class CreateSprintRequest {

    private final String name;

    private final LocalDateTime startAt;

    private final LocalDateTime endAt;

}
