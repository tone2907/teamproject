package com.example.demo.controller;

import com.example.demo.entity.PostsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import com.example.demo.DTO.*;
import com.example.demo.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostsController {
    private final PostsService postsService;

    @PostMapping("/Article/Articlecreate")
    public Long create(@RequestBody PostsCreateRequestDTO requestDTO){
        return postsService.create(requestDTO);
    }
    @PutMapping("/Article/{postId}")
    public Long update(@PathVariable Long postId, @RequestBody PostsUpdateRequestDTO requestDTO){
        return postsService.update(postId, requestDTO);
    }
    @GetMapping("/Article/{postId}")
    public PostsResponseDTO searchById(@PathVariable Long postId){
        return postsService.searchById(postId);
    }
    @GetMapping("/Article")
    public List<PostsListResponseDTO> searchAllDesc() {
        return postsService.searchAllDesc();
    }
    @DeleteMapping("/Article/{postId}")
    public void delete(@PathVariable Long postId){
        postsService.delete(postId);
    }

    @GetMapping("/Article/detail/{postId}")
    public String read(@PathVariable Long postId, Model model) {
        PostsResponseDTO dto = postsService.searchById(postId);
        postsService.updateView(postId);
        model.addAttribute("Article",dto);

        return "post-detail";
    }
    @GetMapping("/")
    public String index(Model model, @PageableDefault(sort = "postId", direction = Sort.Direction.DESC)
                        Pageable pageable) {
        Page<PostsEntity> list = postsService.pageList(pageable);
        model.addAttribute("Posts",list);
        model.addAttribute("prev",pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next",pageable.next().getPageNumber());
        model.addAttribute("hasNext",list.hasNext());
        model.addAttribute("hasPrev",list.hasPrevious());
        return "index";
    }
}
