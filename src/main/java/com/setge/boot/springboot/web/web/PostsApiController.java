package com.setge.boot.springboot.web.web;

import com.setge.boot.springboot.web.domain.posts.PostsRepository;
import com.setge.boot.springboot.web.service.posts.PostsService;
import com.setge.boot.springboot.web.web.dto.PostsResponseDto;
import com.setge.boot.springboot.web.web.dto.PostsSaveRequestDto;
import com.setge.boot.springboot.web.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor // final이 붙은 필드를 인자값으로하는 생성자를 만들어준다.
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts") // 생성
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}") // 수정&조회
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
