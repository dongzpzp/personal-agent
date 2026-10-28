package com.dzp.learning_assistant.model.dto;

import lombok.Data;
import lombok.NonNull;

/**
 * UserDTO
 *
 * 接收用户参数
 */
@Data
public class UserDTO {
    @NonNull
    private String username;
    @NonNull
    private String password;
    private String avatarUrl;
}
