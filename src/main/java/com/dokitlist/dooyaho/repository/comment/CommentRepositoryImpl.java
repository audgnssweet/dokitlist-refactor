package com.dokitlist.dooyaho.repository.comment;

import com.dokitlist.dooyaho.domain.comment.Comment;
import com.dokitlist.dooyaho.domain.comment.QComment;
import com.dokitlist.dooyaho.repository.SimpleFailRepository;
import com.querydsl.core.types.dsl.PathBuilderFactory;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.Querydsl;


public class CommentRepositoryImpl extends SimpleFailRepository<Comment, Long> implements CommentRepositorySupport {

    private final JPAQueryFactory queryFactory;
    private final Querydsl querydsl;

    public CommentRepositoryImpl(
        @Autowired JPAQueryFactory queryFactory,
        @Autowired EntityManager em
    ) {
        super(Comment.class);
        this.queryFactory = queryFactory;
        this.querydsl = new Querydsl(em, new PathBuilderFactory().create(Comment.class));
    }

    @Override
    public Page<Comment> findAllWithPost(Pageable pageable, Long postId) {
        final JPAQuery<Comment> query = queryFactory.selectFrom(QComment.comment)
            .where(QComment.comment.post.id.eq(postId))
            .fetchAll();

        long totalElements = query.fetchCount();

        final List<Comment> list = querydsl.applyPagination(pageable, query).fetch();
        return new PageImpl<>(list, pageable, totalElements);
    }
}
