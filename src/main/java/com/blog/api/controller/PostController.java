package com.blog.api.controller;

import com.blog.api.domain.Post;
import com.blog.api.request.PostCreate;
import com.blog.api.service.PostService;
import jakarta.validation.Valid;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public Long post(@RequestBody @Valid PostCreate postCreate) {
        return postService.write(postCreate);
    }

    @GetMapping("/posts/{postId}")
    public Post get(@PathVariable("postId") Long postId) {
        return postService.findById(postId);
    }

}
