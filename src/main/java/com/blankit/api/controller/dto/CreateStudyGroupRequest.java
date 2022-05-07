package com.blankit.api.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public class CreateStudyGroupRequest {

    @NotBlank(message = "스터디그룹 이름을 입력해주세요.")
    @Pattern(
            regexp = "^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,50}$"
            , message = "스터디그룹 이름은 2자 이상 50자 이하의 영어 또는 숫자 또는 한글로 구성되어야 합니다."
    )
    private final String name;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CreateStudyGroupRequest(@JsonProperty("name") String name) {
        this.name = name;
    }

}