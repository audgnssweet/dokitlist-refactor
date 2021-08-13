package com.dokitlist.dooyaho.domain.community.post.model;

import org.springframework.transaction.annotation.Transactional;

public interface PostRepositorySupport {

    @Transactional
    Post findByIdOrFail(Long id);

    @Transactional
    void deleteByIdOrFail(Long id);
}
