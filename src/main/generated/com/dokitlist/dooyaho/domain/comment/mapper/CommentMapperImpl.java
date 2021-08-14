package com.dokitlist.dooyaho.domain.comment.mapper;

import com.dokitlist.dooyaho.domain.PagePayload;
import com.dokitlist.dooyaho.domain.comment.Comment;
import com.dokitlist.dooyaho.domain.comment.res.CommentResPayload;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-14T22:09:47+0900",
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

    @Override
    public PagePayload<CommentResPayload> toPagePayload(Integer totalPages, Integer numberOfElements, List<CommentResPayload> list) {
        if ( totalPages == null && numberOfElements == null && list == null ) {
            return null;
        }

        PagePayload<CommentResPayload> pagePayload = new PagePayload<CommentResPayload>();

        if ( totalPages != null ) {
            pagePayload.setTotalPages( totalPages );
        }
        if ( numberOfElements != null ) {
            pagePayload.setNumberOfElements( numberOfElements );
        }
        if ( list != null ) {
            List<CommentResPayload> list1 = list;
            if ( list1 != null ) {
                pagePayload.setList( new ArrayList<CommentResPayload>( list1 ) );
            }
        }

        return pagePayload;
    }
}
