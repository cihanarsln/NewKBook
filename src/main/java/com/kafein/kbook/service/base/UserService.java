package com.kafein.kbook.service.base;

import com.kafein.kbook.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

    UserDTO save(UserDTO userDTO);

    List<UserDTO> findAll();

}
