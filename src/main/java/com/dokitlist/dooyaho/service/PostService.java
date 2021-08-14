package com.dokitlist.dooyaho.service;

import com.dokitlist.dooyaho.domain.post.Post;
import com.dokitlist.dooyaho.domain.post.req.PostReq;
import com.dokitlist.dooyaho.repository.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Post save(PostReq req) {
        return postRepository.save(
            Post.builder()
                .title(req.getTitle())
                .content(req.getContent())
                .build()
        );
    }

    @Transactional
    public Post updateById(Long postId, PostReq req) {
        final Post post = postRepository.findByIdElseError(postId);
        return post.update(req.getTitle(), req.getContent());
    }

}
