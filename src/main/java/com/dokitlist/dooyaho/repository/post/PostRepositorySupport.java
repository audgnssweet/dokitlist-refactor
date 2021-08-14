package com.dokitlist.dooyaho.repository.post;

import com.dokitlist.dooyaho.domain.post.Post;
import com.dokitlist.dooyaho.repository.FailRepository;
import java.util.List;

public interface PostRepositorySupport extends FailRepository<Post, Long> {

    List<Post> findAllWithCommentFetch();

}
