package com.appsdeveloper.orderapp.users.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.appsdeveloper.orderapp.users.dto.UserDTO;
import com.appsdeveloper.orderapp.users.entity.User;

@Component
@Mapper
public interface UserMapper {
	UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

	UserDTO mapToUserDto(User user);

	User mapToUser(UserDTO userDto);
}
