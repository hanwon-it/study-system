package com.koreait.restapi.service;

import com.koreait.restapi.dto.PostDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface PostService {
    void insertPost(PostDTO member);
    List<PostDTO> getPosts(int page, int size);
    void insertPostWithImage(PostDTO post, MultipartFile image) throws IOException;
    boolean updatePost(PostDTO post);
    void deletePost(int id);
    PostDTO findById(int id);
}
