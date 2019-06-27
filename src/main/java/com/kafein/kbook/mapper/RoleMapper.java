package com.kafein.kbook.mapper;

import com.kafein.kbook.dto.RoleDTO;
import com.kafein.kbook.model.Role;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Named("toRole")
    Role toRole(RoleDTO roleDTO);

    @Named("toRoleDTO")
    RoleDTO toRoleDTO(Role role);

    @IterableMapping(qualifiedByName = "toRole")
    List<Role> toRoleList(List<RoleDTO> roleDTOList);

    @IterableMapping(qualifiedByName = "toRoleDTO")
    List<RoleDTO> toRoleDTOList(List<Role> roleList);

}
