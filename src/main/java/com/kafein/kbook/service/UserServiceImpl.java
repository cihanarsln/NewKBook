package com.kafein.kbook.service;

import com.kafein.kbook.dto.UserDTO;
import com.kafein.kbook.mapper.UserMapper;
import com.kafein.kbook.service.base.UserService;
import com.kafein.kbook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO save(UserDTO userDTO) {
        userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        return userMapper.toUserDTO(userRepository.save(userMapper.toUser(userDTO)));
    }

    @Override
    public List<UserDTO> findAll() {
        return userMapper.toUserDTOList(userRepository.findAll());
    }
}
