package com.codingshuttle.sathwik.prod_ready_features.services;

import com.codingshuttle.sathwik.prod_ready_features.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> findAllPosts();

    PostDTO createNewPost(PostDTO postDTO);

    PostDTO findPostById(Long postId);
}
