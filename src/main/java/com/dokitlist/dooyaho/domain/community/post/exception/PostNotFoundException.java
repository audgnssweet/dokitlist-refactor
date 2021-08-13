package com.dokitlist.dooyaho.domain.community.post.exception;

import com.dokitlist.dooyaho.common.exception.DokitlistException;
import com.dokitlist.dooyaho.common.exception.ErrorCode;
import org.springframework.http.HttpStatus;

public class PostNotFoundException extends DokitlistException {

    public PostNotFoundException() {
        super(
            "Post Entity is Not Found",
            HttpStatus.NOT_FOUND,
            ErrorCode.ENTITY_NOT_FOUND
        );
    }
}
