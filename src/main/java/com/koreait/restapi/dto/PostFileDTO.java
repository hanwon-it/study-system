package com.koreait.restapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class PostFileDTO {
    private int postId;
    private String originalName;
    private String savedName;
    private String thumbnailName;
    private String uploadPath;
}