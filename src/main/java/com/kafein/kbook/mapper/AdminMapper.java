package com.kafein.kbook.mapper;

import com.kafein.kbook.dto.AdminDTO;
import com.kafein.kbook.model.Admin;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    @Named("toAdmin")
    Admin toAdmin(AdminDTO adminDTO);

    @Named("toAdminDTO")
    AdminDTO toAdminDTO(Admin admin);

    @IterableMapping(qualifiedByName = "toAdmin")
    List<Admin> toAdminList(List<AdminDTO> adminDTOList);

    @IterableMapping(qualifiedByName = "toAdminDTO")
    List<AdminDTO> toAdminDTOList(List<Admin> adminList);

}
