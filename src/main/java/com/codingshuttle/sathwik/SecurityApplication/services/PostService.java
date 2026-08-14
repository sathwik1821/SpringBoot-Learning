package com.codingshuttle.sathwik.SecurityApplication.services;

import com.codingshuttle.sathwik.SecurityApplication.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> findAllPosts();

    PostDTO createNewPost(PostDTO postDTO);

    PostDTO findPostById(Long postId);
}
