package com.dokitlist.dooyaho.repository.comment;

import com.dokitlist.dooyaho.domain.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>, CommentRepositorySupport {

}
