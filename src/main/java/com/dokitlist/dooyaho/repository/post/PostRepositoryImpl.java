package com.dokitlist.dooyaho.repository.post;

import com.dokitlist.dooyaho.domain.comment.QComment;
import com.dokitlist.dooyaho.domain.post.Post;
import com.dokitlist.dooyaho.domain.post.QPost;
import com.dokitlist.dooyaho.repository.SimpleFailRepository;
import com.querydsl.core.types.dsl.PathBuilderFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.Querydsl;

public class PostRepositoryImpl extends SimpleFailRepository<Post, Long> implements PostRepositorySupport {

    private final JPAQueryFactory queryFactory;
    private final Querydsl querydsl;

    public PostRepositoryImpl(
        @Autowired JPAQueryFactory queryFactory,
        @Autowired EntityManager em
    ) {
        super(Post.class);
        this.queryFactory = queryFactory;
        this.querydsl = new Querydsl(em, new PathBuilderFactory().create(Post.class));
    }

    @Override
    public List<Post> findAllWithCommentFetch() {
        return queryFactory.selectFrom(QPost.post)
            .leftJoin(QPost.post.comments, QComment.comment)
            .fetchJoin()
            .distinct()
            .fetch();
    }
}
