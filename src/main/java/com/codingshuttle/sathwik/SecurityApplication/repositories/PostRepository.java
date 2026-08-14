package com.codingshuttle.sathwik.SecurityApplication.repositories;

import com.codingshuttle.sathwik.SecurityApplication.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {
}
