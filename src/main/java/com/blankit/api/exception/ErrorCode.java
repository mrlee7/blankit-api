package com.blankit.api.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    INVALID_INPUT_VALUE("VL0001", "잘못된 입력값입니다.", 400),
    DUPLICATION("MEMBER-ERR-400","중복처리된 입력값입니다", 400)
    ;

    private final String code;
    private final String message;
    private final int status;

    public String getMessage() {

        return this.message;
    }

    public String getCode() {

        return code;
    }

    public int getStatus() {

        return status;
    }
}

