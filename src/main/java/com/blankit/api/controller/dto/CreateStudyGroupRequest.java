package com.blankit.api.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateStudyGroupRequest {

    private final String name;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CreateStudyGroupRequest(@JsonProperty("name") String name) {
        this.name = name;
    }

}
