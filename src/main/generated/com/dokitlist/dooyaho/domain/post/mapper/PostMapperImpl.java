package com.dokitlist.dooyaho.domain.post.mapper;

import com.dokitlist.dooyaho.domain.post.Post;
import com.dokitlist.dooyaho.domain.post.res.PostPagePayload;
import com.dokitlist.dooyaho.domain.post.res.PostResPayload;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-14T18:19:00+0900",
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
    public PostPagePayload toPagePayload(Integer totalPages, Integer numberOfElements, List<PostResPayload> posts) {
        if ( totalPages == null && numberOfElements == null && posts == null ) {
            return null;
        }

        PostPagePayload postPagePayload = new PostPagePayload();

        if ( totalPages != null ) {
            postPagePayload.setTotalPages( totalPages );
        }
        if ( numberOfElements != null ) {
            postPagePayload.setNumberOfElements( numberOfElements );
        }
        if ( posts != null ) {
            List<PostResPayload> list = posts;
            if ( list != null ) {
                postPagePayload.setPosts( new ArrayList<PostResPayload>( list ) );
            }
        }

        return postPagePayload;
    }
}
