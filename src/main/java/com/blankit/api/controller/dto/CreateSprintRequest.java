package com.blankit.api.controller.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class CreateSprintRequest {

    @NotBlank(message = "스프린트 이름을 입력해주세요.")
    @Pattern(
            regexp = "^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,50}$"
            , message = "스프린트 이름은 2자 이상 50자 이하의 영어 또는 숫자 또는 한글로 구성되어야 합니다."
    )
    private final String name;

    private final LocalDateTime startAt;

    private final LocalDateTime endAt;

}