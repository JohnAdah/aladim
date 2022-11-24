package com.trader.smarttrade.Mapper;

import com.trader.smarttrade.DTOs.UserDTO;
import com.trader.smarttrade.Entities.Users;

public class UsersMapper {

    public static Users UsersDtoToUsers(UserDTO newUser){
        return Users.builder().userId(newUser.getUserId()).
                userName(newUser.getUserName())
                .firstName(newUser.getFirstName())
                .lastName(newUser.getLastName())
                .password(newUser.getPassword())
                .email(newUser.getEmail())
                .homeAddress(newUser.getHomeAddress())
                .phoneNumber(newUser.getPhoneNumber())
                .idNumber(newUser.getIdNumber())
                .idType(newUser.getIdType()).roles(newUser.getRole()).build();
    }

    public static UserDTO UserToUserDTO(Users newUser){
        return UserDTO.builder().userId(newUser.getUserId())
                .userName(newUser.getUserName())
                .firstName(newUser.getFirstName())
                .lastName(newUser.getLastName())
                .password(newUser.getPassword())
                .email(newUser.getEmail())
                .homeAddress(newUser.getHomeAddress())
                .phoneNumber(newUser.getPhoneNumber())
                .idNumber(newUser.getIdNumber())
                .idType(newUser.getIdType()).role(newUser.getRoles()).build();
    }
}
