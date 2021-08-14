package com.dokitlist.dooyaho.repository.comment;

import com.dokitlist.dooyaho.domain.comment.Comment;
import com.dokitlist.dooyaho.repository.FailRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentRepositorySupport extends FailRepository<Comment, Long> {

    Page<Comment> findAllWithPost(Pageable pageable, Long postId);

}
