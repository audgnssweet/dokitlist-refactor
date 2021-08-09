package com.dokitlist.dooyaho.domain.community.post.mapper;

import com.dokitlist.dooyaho.domain.community.post.model.Post;
import com.dokitlist.dooyaho.domain.community.post.res.PostResPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostResPayload toResPayload(Post post);

}
