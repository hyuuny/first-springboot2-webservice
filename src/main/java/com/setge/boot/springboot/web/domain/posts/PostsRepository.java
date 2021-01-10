package com.setge.boot.springboot.web.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> { // <Entity클래스, PK타입>

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC") // id를 기준으로 역순 정렬
    List<Posts> findAllDesc();

}
