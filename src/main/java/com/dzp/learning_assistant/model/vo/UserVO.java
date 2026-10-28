package com.dzp.learning_assistant.model.vo;

import com.dzp.learning_assistant.enums.UserRoleEnum;
import lombok.Data;

/**
 * UserVO
 *
 * 用户 返回参数
 */
@Data
public class UserVO {
    private Long id;
    private String username;
    private String avatarUrl;
    private String token;
    private UserRoleEnum role;
}
