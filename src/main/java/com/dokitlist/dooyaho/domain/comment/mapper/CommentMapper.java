package com.dokitlist.dooyaho.domain.comment.mapper;

import com.dokitlist.dooyaho.domain.PagePayload;
import com.dokitlist.dooyaho.domain.comment.Comment;
import com.dokitlist.dooyaho.domain.comment.res.CommentResPayload;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentResPayload toResPayload(Comment comment);

    default PagePayload<CommentResPayload> toPagePayload(Page<Comment> page) {
        return toPagePayload(
            page.getTotalPages(),
            page.getNumberOfElements(),
            page.getContent().stream().map(CommentMapper.INSTANCE::toResPayload).collect(Collectors.toList())
        );
    }

    PagePayload<CommentResPayload> toPagePayload(
        Integer totalPages,
        Integer numberOfElements,
        List<CommentResPayload> list
    );
}
