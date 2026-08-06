package com.codingshuttle.sathwik.prod_ready_features.services;

import com.codingshuttle.sathwik.prod_ready_features.dto.PostDTO;
import com.codingshuttle.sathwik.prod_ready_features.entities.PostEntity;
import com.codingshuttle.sathwik.prod_ready_features.exceptions.RescourceNotFoundException;
import com.codingshuttle.sathwik.prod_ready_features.repositories.PostRepository;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDTO> findAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO postDTO) {
        PostEntity postEntity=postRepository.save(modelMapper.map(postDTO, PostEntity.class));
        return modelMapper.map(postEntity, PostDTO.class);
    }

    @Override
    public PostDTO findPostById(Long postId) {

        PostEntity postEntity = postRepository
                .findById(postId)
                .orElseThrow(()->new RescourceNotFoundException("Post with given id was not found"));

        return modelMapper.map(postEntity, PostDTO.class);
    }

    @Override
    public PostDTO updatePost(Long postId, PostDTO postDTO) {
        PostEntity postEntity = postRepository
                .findById(postId)
                .orElseThrow(()->new RescourceNotFoundException("Post with given id was not found"));

        postDTO.setId(postId);
        modelMapper.map(postDTO, postEntity);
        PostEntity updatedPostEntity = postRepository.save(postEntity);
        return modelMapper.map(updatedPostEntity, PostDTO.class);
    }
}
