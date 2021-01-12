package com.setge.boot.springboot.web.web.dto;

import com.setge.boot.springboot.web.config.auth.LoginUser;
import com.setge.boot.springboot.web.config.auth.dto.SessionUser;
import com.setge.boot.springboot.web.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        if(user != null)
            model.addAttribute("userName", user.getName());

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {

        return "posts-save"; // /resources/templates/posts-save.mustache로 이동한다.
    }

    @GetMapping("/posts/update/{id}") // 게시물 수정
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update"; // post 객체에 id값 객체를 저장해서 update페이지로 이동한다.
    }
}
