package com.kafein.kbook.service.base;

import com.kafein.kbook.dto.RoleDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleService {

    RoleDTO save(RoleDTO role);

    List<RoleDTO> findAll();

}
