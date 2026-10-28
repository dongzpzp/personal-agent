package com.dzp.learning_assistant.controller;

import com.dzp.learning_assistant.model.dto.UserDTO;
import com.dzp.learning_assistant.model.vo.Result;
import com.dzp.learning_assistant.model.vo.UserVO;
import com.dzp.learning_assistant.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/learning-assistant/user")
@AllArgsConstructor
@Tag(name = "用户模块接口")
public class UserController {
    private final UserService userService;

    //用户注册
    @PostMapping("/register")
    @Operation(summary = "用户注册")
    public Result<UserVO> register(@NonNull @Valid @RequestBody UserDTO userDTO) {
        UserVO userVO = userService.register(userDTO);
        return Result.success(userVO);
    }

    //用户登录
    @PostMapping("/login")
    @Operation(summary = "用户登录")
    public Result<UserVO> login(@NonNull @Valid @RequestBody UserDTO userDTO) {
        UserVO userVO = userService.login(userDTO);
        return Result.success(userVO);
    }

    //TODO: 管理员分页查询用户

}
