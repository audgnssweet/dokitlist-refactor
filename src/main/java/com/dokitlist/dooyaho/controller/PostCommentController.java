package com.dokitlist.dooyaho.controller;

import com.dokitlist.dooyaho.domain.PagePayload;
import com.dokitlist.dooyaho.domain.comment.Comment;
import com.dokitlist.dooyaho.domain.comment.mapper.CommentMapper;
import com.dokitlist.dooyaho.domain.comment.res.CommentResPayload;
import com.dokitlist.dooyaho.repository.PageRequestFactory;
import com.dokitlist.dooyaho.repository.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1")
@RequiredArgsConstructor
@RestController
public class PostCommentController {

    private final CommentRepository commentRepository;
    private final PageRequestFactory pageRequestFactory = PageRequestFactory.from(Comment.class);

    @GetMapping("/posts/{post-id}/comments")
    @ResponseStatus(HttpStatus.OK)
    public PagePayload<CommentResPayload> findAll(
        @PathVariable(name = "post-id") Long postId,
        @RequestParam(name = "page", required = false) Integer page,
        @RequestParam(name = "size", required = false) Integer size,
        @RequestParam(name = "sort", required = false) String property,
        @RequestParam(name = "order", required = false) Sort.Direction direction
    ) {
        final Page<Comment> res = commentRepository.findAllWithPost(
            pageRequestFactory.of(
                page,
                size,
                property,
                direction
            ),
            postId
        );
        return CommentMapper.INSTANCE.toPagePayload(res);
    }

}
