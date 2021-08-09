package com.dokitlist.dooyaho.domain.community.post.res;

import com.dokitlist.dooyaho.domain.community.post.model.Post;
import lombok.Data;

@Data
public class PostCreateRes {

    private Long id;
    private String title;
    private String content;

    public PostCreateRes(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
