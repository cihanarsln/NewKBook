package com.kafein.kbook.service;

import com.kafein.kbook.dto.RoleDTO;
import com.kafein.kbook.mapper.RoleMapper;
import com.kafein.kbook.repository.RoleRepository;
import com.kafein.kbook.service.base.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public RoleDTO save(RoleDTO role) {
        return roleMapper.toRoleDTO(roleRepository.save(roleMapper.toRole(role)));
    }

    @Override
    public List<RoleDTO> findAll() {
        return roleMapper.toRoleDTOList(roleRepository.findAll());
    }
}
