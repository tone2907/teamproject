package com.example.demo.controller;

import com.example.demo.DTO.LikeRequestDTO;
import com.example.demo.service.LikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
public class LikeController {
    private final LikeService likeService;

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody @Validated LikeRequestDTO likeRequestDTO) throws Exception {
        likeService.insert(likeRequestDTO);
        return success(null);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody @Validated LikeRequestDTO likeRequestDTO) throws ChangeSetPersister.NotFoundException {
        likeService.delete(likeRequestDTO);
        return success(null);
    }

    private ResponseEntity<?> success(Integer o) {
        return null;
    }
}
