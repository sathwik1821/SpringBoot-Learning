package com.codingshuttle.sathwik.SecurityApplication.controllers;

import com.codingshuttle.sathwik.SecurityApplication.dto.PostDTO;
import com.codingshuttle.sathwik.SecurityApplication.services.PostService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/posts" )
public class PostController {

    private final PostService postService;

    @GetMapping
    @PreAuthorize("hasAuthority('POST_VIEW')")
    public List<PostDTO> findAllPosts() {
        return postService.findAllPosts();
    }

    @GetMapping(path = "/{postId}")
    @PreAuthorize("hasAuthority('POST_VIEW')")
    public PostDTO findPostById(@PathVariable Long postId) {
        return postService.findPostById(postId);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('POST_CREATE') and hasAnyRole('ADMIN', 'USER')")
    public PostDTO createNewPost(@RequestBody PostDTO postDTO) {
        return postService.createNewPost(postDTO);
    }

}
