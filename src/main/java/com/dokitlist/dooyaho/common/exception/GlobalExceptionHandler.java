package com.dokitlist.dooyaho.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DokitlistException.class)
    public ResponseEntity<?> handleDokitlistException(DokitlistException e) {
        return new ResponseEntity<>(ErrorRes.from(e), e.getStatus());
    }

}
