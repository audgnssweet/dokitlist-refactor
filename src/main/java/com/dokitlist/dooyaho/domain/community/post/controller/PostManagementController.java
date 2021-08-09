package com.dokitlist.dooyaho.domain.community.post.controller;

import com.dokitlist.dooyaho.domain.community.post.req.PostCreateReq;
import com.dokitlist.dooyaho.domain.community.post.res.PostResPayload;
import com.dokitlist.dooyaho.domain.community.post.service.PostManageService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/v1/posts")
@RestController
public class PostManagementController {

    private final PostManageService postManageService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public PostResPayload createPost(@RequestBody @Valid PostCreateReq req) {
        return postManageService.create(req);
    }

}