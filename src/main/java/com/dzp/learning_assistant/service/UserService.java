package com.dzp.learning_assistant.service;

import com.dzp.learning_assistant.model.dto.UserDTO;
import com.dzp.learning_assistant.model.vo.UserVO;

public interface UserService {
    UserVO register(UserDTO userDTO);
    UserVO login(UserDTO userDTO);

//    PageResult<UserPageItemVO> query(UserPageRequest request);
}
