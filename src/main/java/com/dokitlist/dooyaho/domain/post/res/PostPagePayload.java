package com.dokitlist.dooyaho.domain.post.res;

import java.util.List;
import lombok.Data;

@Data
public class PostPagePayload {

    private int totalPages;
    private int numberOfElements;
    private List<PostResPayload> posts;
}