package com.dokitlist.dooyaho.domain.comment.mapper;

import com.dokitlist.dooyaho.domain.comment.Comment;
import com.dokitlist.dooyaho.domain.comment.res.CommentResPayload;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentResPayload toResPayload(Comment comment);
}
