package com.dokitlist.dooyaho.domain.community.post.service;

import com.dokitlist.dooyaho.domain.community.post.model.Post;
import com.dokitlist.dooyaho.domain.community.post.model.PostRepository;
import com.dokitlist.dooyaho.domain.community.post.req.PostCreateReq;
import com.dokitlist.dooyaho.domain.community.post.res.PostCreateRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostManageService {

    private final PostRepository postRepository;

    @Transactional
    public PostCreateRes create(PostCreateReq req) {
        final Post post = postRepository.save(
            Post.builder()
                .title(req.getTitle())
                .content(req.getContent())
                .build()
        );
        return new PostCreateRes(post);
    }

}
