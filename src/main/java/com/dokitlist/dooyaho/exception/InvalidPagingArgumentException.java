package com.dokitlist.dooyaho.exception;

import org.springframework.http.HttpStatus;

public class InvalidPagingArgumentException extends DokitlistException {

    public InvalidPagingArgumentException() {
        super(
            "Paging Argument is Invalid",
            HttpStatus.BAD_REQUEST,
            ErrorCode.INVALID_PAGING_ARGUMENT
        );
    }
}