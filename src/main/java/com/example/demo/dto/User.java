package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class User {
    private Long id;
    private String userId;
    private String userPw;
    private String nickname;
    private String userName;
    private String email;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
}
