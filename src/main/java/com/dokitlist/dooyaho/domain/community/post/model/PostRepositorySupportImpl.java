package com.dokitlist.dooyaho.domain.community.post.model;

import com.dokitlist.dooyaho.domain.community.post.exception.PostNotFoundException;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostRepositorySupportImpl implements PostRepositorySupport {

    private final EntityManager em;

    @Override
    public Post findByIdOrFail(Long id) {
        final Post post = em.find(Post.class, id);
        if (post == null) {
            throw new PostNotFoundException();
        }
        return post;
    }

    @Override
    public void deleteByIdOrFail(Long id) {
        final Post post = findByIdOrFail(id);
        em.remove(post);
    }
}
