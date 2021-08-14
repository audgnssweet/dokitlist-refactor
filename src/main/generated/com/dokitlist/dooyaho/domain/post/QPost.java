package com.dokitlist.dooyaho.domain.post;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = -179760079L;

    public static final QPost post = new QPost("post");

    public final com.dokitlist.dooyaho.domain.QBaseTimeEntity _super = new com.dokitlist.dooyaho.domain.QBaseTimeEntity(this);

    public final ListPath<com.dokitlist.dooyaho.domain.comment.Comment, com.dokitlist.dooyaho.domain.comment.QComment> comments = this.<com.dokitlist.dooyaho.domain.comment.Comment, com.dokitlist.dooyaho.domain.comment.QComment>createList("comments", com.dokitlist.dooyaho.domain.comment.Comment.class, com.dokitlist.dooyaho.domain.comment.QComment.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QPost(String variable) {
        super(Post.class, forVariable(variable));
    }

    public QPost(Path<? extends Post> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPost(PathMetadata metadata) {
        super(Post.class, metadata);
    }

}

