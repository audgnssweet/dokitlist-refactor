package com.dokitlist.dooyaho.common.exception;

import org.springframework.http.HttpStatus;

public class InvalidPagingPropertyException extends DokitlistException {

    public InvalidPagingPropertyException() {
        super(
            "Paging Property is Invalid",
            HttpStatus.BAD_REQUEST,
            ErrorCode.INVALID_PAGING_PROPERTY
        );
    }
}
