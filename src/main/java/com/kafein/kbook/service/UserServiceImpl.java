package com.kafein.kbook.service;

import com.kafein.kbook.dto.UserDTO;
import com.kafein.kbook.mapper.UserMapper;
import com.kafein.kbook.service.base.UserService;
import com.kafein.kbook.model.User;
import com.kafein.kbook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User save(UserDTO userDTO) {
        return userRepository.save(userMapper.toUser(userDTO));
    }

    @Override
    public List<UserDTO> findAll() {
        return userMapper.toUserDTOList(userRepository.findAll());
    }
}
