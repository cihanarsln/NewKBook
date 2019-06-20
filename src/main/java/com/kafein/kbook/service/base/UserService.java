package com.kafein.kbook.service.base;

import com.kafein.kbook.dto.UserDTO;
import com.kafein.kbook.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

    User save(UserDTO userDTO);

    List<UserDTO> findAll();

}
