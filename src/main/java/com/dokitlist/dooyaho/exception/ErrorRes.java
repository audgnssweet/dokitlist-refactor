package com.dokitlist.dooyaho.exception;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorRes {

    private LocalDateTime timestamp;
    private String message;
    private Integer status;
    private ErrorCode code;

    public static ErrorRes from(DokitlistException e) {
        return new ErrorRes(
            LocalDateTime.now(),
            e.getMessage(),
            e.getStatus().value(),
            e.getCode()
        );
    }

}
