package com.dokitlist.dooyaho.domain.comment.req;

import lombok.Data;

@Data
public class CommentReq {
    private Long postId;
    private String content;
}
