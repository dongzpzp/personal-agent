package com.dzp.learning_assistant.model.entity;

import com.dzp.learning_assistant.enums.UserRoleEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * User
 *
 * 用户持久化实体
 */
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String avatarUrl;
    private UserRoleEnum role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
