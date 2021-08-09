package com.dokitlist.dooyaho.domain.community.post.service;

import com.dokitlist.dooyaho.domain.community.post.model.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostRetrieveService {

    private final PostRepository postRepository;

}
