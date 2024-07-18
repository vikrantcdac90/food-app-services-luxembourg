package com.appsdeveloper.orderapp.users.mappers;

import com.appsdeveloper.orderapp.users.dto.UserDTO;
import com.appsdeveloper.orderapp.users.entity.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-01T18:50:47+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240215-1558, environment: Java 17.0.11 (Eclipse Adoptium)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO mapToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        Long userId = null;
        String firstName = null;
        String lastName = null;
        String city = null;
        String postalCode = null;
        String country = null;
        String street = null;
        String email = null;
        String username = null;
        String password = null;

        userId = user.getUserId();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        city = user.getCity();
        postalCode = user.getPostalCode();
        country = user.getCountry();
        street = user.getStreet();
        email = user.getEmail();
        username = user.getUsername();
        password = user.getPassword();

        UserDTO userDTO = new UserDTO( userId, firstName, lastName, city, postalCode, country, street, email, username, password );

        return userDTO;
    }

    @Override
    public User mapToUser(UserDTO userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setCity( userDto.city() );
        user.setCountry( userDto.country() );
        user.setEmail( userDto.email() );
        user.setFirstName( userDto.firstName() );
        user.setLastName( userDto.lastName() );
        user.setPassword( userDto.password() );
        user.setPostalCode( userDto.postalCode() );
        user.setStreet( userDto.street() );
        user.setUserId( userDto.userId() );
        user.setUsername( userDto.username() );

        return user;
    }
}
