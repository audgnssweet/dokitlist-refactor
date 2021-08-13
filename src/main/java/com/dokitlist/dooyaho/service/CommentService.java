package com.dokitlist.dooyaho.service;

import com.dokitlist.dooyaho.domain.comment.Comment;
import com.dokitlist.dooyaho.domain.comment.req.CommentReq;
import com.dokitlist.dooyaho.domain.post.Post;
import com.dokitlist.dooyaho.repository.comment.CommentRepository;
import com.dokitlist.dooyaho.repository.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional
    public Comment save(CommentReq req) {
        final Post post = postRepository.findByIdOrFail(req.getPostId());
        return commentRepository.save(
            Comment.builder()
                .content(req.getContent())
                .post(post)
                .build()
        );
    }

    @Transactional
    public Comment update(Long commentId, CommentReq req) {
        return commentRepository.findByIdOrFail(commentId).update(req.getContent());
    }
}
