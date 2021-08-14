package com.dokitlist.dooyaho.repository.post;

import com.dokitlist.dooyaho.domain.post.Post;
import com.dokitlist.dooyaho.repository.SimpleFailRepository;

public class PostRepositoryImpl extends SimpleFailRepository<Post, Long> {

    public PostRepositoryImpl() {
        super(Post.class);
    }
}
