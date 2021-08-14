package com.dokitlist.dooyaho.domain.comment.mapper;

import com.dokitlist.dooyaho.domain.comment.Comment;
import com.dokitlist.dooyaho.domain.comment.res.CommentResPayload;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-14T18:19:01+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.9 (Oracle Corporation)"
)
public class CommentMapperImpl implements CommentMapper {

    @Override
    public CommentResPayload toResPayload(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentResPayload commentResPayload = new CommentResPayload();

        commentResPayload.setId( comment.getId() );
        commentResPayload.setContent( comment.getContent() );

        return commentResPayload;
    }
}
