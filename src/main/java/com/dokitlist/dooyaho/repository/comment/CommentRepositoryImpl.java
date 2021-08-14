package com.dokitlist.dooyaho.repository.comment;

import com.dokitlist.dooyaho.domain.comment.Comment;
import com.dokitlist.dooyaho.repository.SimpleFailRepository;

public class CommentRepositoryImpl extends SimpleFailRepository<Comment, Long> {

    public CommentRepositoryImpl() {
        super(Comment.class);
    }
}
