package com.dokitlist.dooyaho.repository.post;

import com.dokitlist.dooyaho.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositorySupport {

}
