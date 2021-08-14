package com.dokitlist.dooyaho.domain.post.mapper;

import com.dokitlist.dooyaho.domain.PagePayload;
import com.dokitlist.dooyaho.domain.post.Post;
import com.dokitlist.dooyaho.domain.post.res.PostResPayload;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-14T22:09:46+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.9 (Oracle Corporation)"
)
public class PostMapperImpl implements PostMapper {

    @Override
    public PostResPayload toResPayload(Post post) {
        if ( post == null ) {
            return null;
        }

        PostResPayload postResPayload = new PostResPayload();

        postResPayload.setId( post.getId() );
        postResPayload.setTitle( post.getTitle() );
        postResPayload.setContent( post.getContent() );
        postResPayload.setCreatedAt( post.getCreatedAt() );
        postResPayload.setUpdatedAt( post.getUpdatedAt() );

        return postResPayload;
    }

    @Override
    public PostResPayload toResOutlinePayload(Post post) {
        if ( post == null ) {
            return null;
        }

        PostResPayload postResPayload = new PostResPayload();

        postResPayload.setId( post.getId() );
        postResPayload.setTitle( post.getTitle() );
        postResPayload.setCreatedAt( post.getCreatedAt() );

        return postResPayload;
    }

    @Override
    public PagePayload<PostResPayload> toPagePayload(Integer totalPages, Integer numberOfElements, List<PostResPayload> list) {
        if ( totalPages == null && numberOfElements == null && list == null ) {
            return null;
        }

        PagePayload<PostResPayload> pagePayload = new PagePayload<PostResPayload>();

        if ( totalPages != null ) {
            pagePayload.setTotalPages( totalPages );
        }
        if ( numberOfElements != null ) {
            pagePayload.setNumberOfElements( numberOfElements );
        }
        if ( list != null ) {
            List<PostResPayload> list1 = list;
            if ( list1 != null ) {
                pagePayload.setList( new ArrayList<PostResPayload>( list1 ) );
            }
        }

        return pagePayload;
    }
}
