package com.kafein.kbook.mapper;

import com.kafein.kbook.dto.UserDTO;
import com.kafein.kbook.model.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {LoanMapper.class})
public interface UserMapper {

    @Named("toUser")
    User toUser(UserDTO userDTO);

    @Named("toUserDTO")
    UserDTO toUserDTO(User user);

    @IterableMapping(qualifiedByName = "toUser")
    List<User> toUserList(List<UserDTO> userDTOList);

    @IterableMapping(qualifiedByName = "toUserDTO")
    List<UserDTO> toUserDTOList(List<User> userList);


}
