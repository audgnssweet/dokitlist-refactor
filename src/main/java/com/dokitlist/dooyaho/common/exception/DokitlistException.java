package com.dokitlist.dooyaho.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public abstract class DokitlistException extends RuntimeException{

    private String message;
    private HttpStatus status;
    private ErrorCode code;

}
