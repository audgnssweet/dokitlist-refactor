package com.dokitlist.dooyaho.domain.community.post.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositorySupport {

}
