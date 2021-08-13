package com.dokitlist.dooyaho.domain.community.post.service;

import com.dokitlist.dooyaho.domain.community.post.mapper.PostMapper;
import com.dokitlist.dooyaho.domain.community.post.model.Post;
import com.dokitlist.dooyaho.domain.community.post.model.PostRepository;
import com.dokitlist.dooyaho.domain.community.post.req.PostReq;
import com.dokitlist.dooyaho.domain.community.post.res.PostResPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public PostResPayload save(PostReq req) {
        final Post post = postRepository.save(
            Post.builder()
                .title(req.getTitle())
                .content(req.getContent())
                .build()
        );
        return getResPayload(post);
    }

    private PostResPayload getResPayload(Post post) {
        return PostMapper.INSTANCE.toResPayload(post);
    }

    @Transactional
    public PostResPayload updateById(Long postId, PostReq req) {
        final Post post = postRepository.findByIdOrFail(postId);
        post.update(req.getTitle(), req.getContent());
        return getResPayload(post);
    }

}
