package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Article {
    private int id;
    private String userId;
    private String title;
    private String files;
    private String description;
    private int type;
    private int likeCount;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
    private String thumbnail;
}
