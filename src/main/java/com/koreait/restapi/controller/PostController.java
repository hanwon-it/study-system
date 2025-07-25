package com.koreait.restapi.controller;

import com.koreait.restapi.dto.PostDTO;
import com.koreait.restapi.jwt.JwtUtil;
import com.koreait.restapi.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final JwtUtil jwtUtil;
    private final PostService postService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PostDTO post, HttpServletRequest request) {
        int userId = jwtUtil.getUserIdFromRequest(request);
        post.setWriterId(userId);
        postService.insertPost(post);
        return ResponseEntity.ok().build();
    }
//    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<?> create(@RequestPart("post") PostDTO post, @RequestPart(value="image", required = false) MultipartFile image, HttpServletRequest request) throws IOException {
//        int userId = jwtUtil.getUserIdFromRequest(request);
//        post.setWriterId(userId);
//        postService.insertPostWithImage(post, image);
//        return ResponseEntity.ok().build();
//    }
    @GetMapping
    public List<PostDTO> list(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "10") int size){
        return postService.getPosts(page, size);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@PathVariable int id, @RequestBody PostDTO post, HttpServletRequest request) {
        int userId = jwtUtil.getUserIdFromRequest(request);
        post.setId(id);           // URL 경로에서 받은 id로 설정
        post.setWriterId(userId); // 작성자 확인용
        boolean updated = postService.updatePost(post);
        if (updated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(404).body("Post not found or permission denied");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable int id, HttpServletRequest request) {
        int userId = jwtUtil.getUserIdFromRequest(request);
        PostDTO post = postService.findById(id);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        if (post.getWriterId() != userId) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostDetail(@PathVariable int id) {
        PostDTO post = postService.findById(id);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post);
    }
}
