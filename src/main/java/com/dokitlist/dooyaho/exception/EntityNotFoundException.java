package com.dokitlist.dooyaho.exception;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends DokitlistException {

    public EntityNotFoundException() {
        super(
            "해당 ID를 찾을 수 없습니다",
            HttpStatus.NOT_FOUND,
            ErrorCode.ENTITY_NOT_FOUND
        );
    }
}
