package com.dokitlist.dooyaho.domain.community.post.mapper;

import com.dokitlist.dooyaho.domain.community.post.model.Post;
import com.dokitlist.dooyaho.domain.community.post.res.PostPagePayload;
import com.dokitlist.dooyaho.domain.community.post.res.PostResPayload;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostResPayload toResPayload(Post post);

    @Mapping(target = "content", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    PostResPayload toResOutlinePayload(Post post);

    default PostPagePayload toPagePayload(Page<Post> page) {
        return toPagePayload(
            page.getTotalPages(),
            page.getNumberOfElements(),
            page.getContent().stream().map(PostMapper.INSTANCE::toResOutlinePayload).collect(Collectors.toList())
        );
    }

    PostPagePayload toPagePayload(Integer totalPages, Integer numberOfElements, List<PostResPayload> posts);

}
