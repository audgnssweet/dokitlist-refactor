package com.dokitlist.dooyaho.controller;

import com.dokitlist.dooyaho.domain.comment.mapper.CommentMapper;
import com.dokitlist.dooyaho.domain.comment.req.CommentReq;
import com.dokitlist.dooyaho.domain.comment.res.CommentResPayload;
import com.dokitlist.dooyaho.repository.comment.CommentRepository;
import com.dokitlist.dooyaho.service.CommentService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/comments")
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;
    private final CommentRepository commentRepository;

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public CommentResPayload save(@RequestBody @Valid CommentReq req) {
        return CommentMapper.INSTANCE.toResPayload(commentService.save(req));
    }

    @GetMapping("/{comment-id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentResPayload findById(@PathVariable(name = "comment-id") Long commentId) {
        return CommentMapper.INSTANCE.toResPayload(commentRepository.findByIdElseError(commentId));
    }

    @PutMapping("/{comment-id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentResPayload updateById(
        @PathVariable(name = "comment-id") Long commentId,
        @RequestBody @Valid CommentReq commentReq
    ) {
        return CommentMapper.INSTANCE.toResPayload(commentService.update(commentId, commentReq));
    }

    @DeleteMapping("/{comment-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable(name = "comment-id") Long commentId) {
        commentRepository.deleteByIdElseError(commentId);
    }

}
