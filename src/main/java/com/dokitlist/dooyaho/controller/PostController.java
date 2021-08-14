package com.dokitlist.dooyaho.controller;

import com.dokitlist.dooyaho.domain.PagePayload;
import com.dokitlist.dooyaho.domain.post.Post;
import com.dokitlist.dooyaho.domain.post.mapper.PostMapper;
import com.dokitlist.dooyaho.domain.post.req.PostReq;
import com.dokitlist.dooyaho.domain.post.res.PostResPayload;
import com.dokitlist.dooyaho.repository.PageRequestFactory;
import com.dokitlist.dooyaho.repository.post.PostRepository;
import com.dokitlist.dooyaho.service.PostService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/v1/posts")
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;
    private final PageRequestFactory pageRequest = PageRequestFactory.from(Post.class);

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public PostResPayload save(@RequestBody @Valid PostReq req) {
        return PostMapper.INSTANCE.toResPayload(postService.save(req));
    }

    @GetMapping("/{post-id}")
    @ResponseStatus(HttpStatus.OK)
    public PostResPayload findById(@PathVariable(name = "post-id") Long postId) {
        return PostMapper.INSTANCE.toResPayload(postRepository.findByIdElseError(postId));
    }

    @PutMapping("/{post-id}")
    @ResponseStatus(HttpStatus.OK)
    public PostResPayload updateById(
        @PathVariable(name = "post-id") Long postId,
        @RequestBody @Valid PostReq req
    ) {
        return PostMapper.INSTANCE.toResPayload(postService.updateById(postId, req));
    }

    @DeleteMapping("/{post-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable(name = "post-id") Long postId) {
        postRepository.findByIdElseError(postId);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public PagePayload<PostResPayload> findAll(
        @RequestParam(name = "page", required = false) Integer page,
        @RequestParam(name = "size", required = false) Integer size,
        @RequestParam(name = "sort", required = false) String property,
        @RequestParam(name = "order", required = false) Sort.Direction direction
    ) {
        final Page<Post> res = postRepository.findAll(
            pageRequest.of(
                page,
                size,
                property,
                direction
            )
        );
        return PostMapper.INSTANCE.toPagePayload(res);
    }
}
