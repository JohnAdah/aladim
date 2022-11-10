package com.trader.smarttrade.Mapper;

import com.trader.smarttrade.DTOs.RegisterMerchantDTO;
import com.trader.smarttrade.DTOs.RegisterUserDTO;
import com.trader.smarttrade.Entities.Users;

public class UsersMapper {

    public static RegisterUserDTO UsersToRegisterUsersDTO(Users user){
        return RegisterUserDTO.builder().userName(user.getUserName())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .email(user.getEmail())
                .homeAddress(user.getHomeAddress())
                .phoneNumber(user.getPhoneNumber())
                .idNumber(user.getIdNumber())
                .idType(user.getIdType())
                .sex(user.getSex())
                .role(user.getRole()).build();
    }

    public static Users RegisterUsersDtoToUsers(RegisterUserDTO newUser){
        return Users.builder().userName(newUser.getUserName())
                .firstName(newUser.getFirstName())
                .lastName(newUser.getLastName())
                .password(newUser.getPassword())
                .email(newUser.getEmail())
                .homeAddress(newUser.getHomeAddress())
                .phoneNumber(newUser.getPhoneNumber())
                .idNumber(newUser.getIdNumber())
                .idType(newUser.getIdType())
                .sex(newUser.getSex())
                .role(newUser.getRole()).build();
    }

    public RegisterMerchantDTO UsersToRegisterMerchantDTO(Users newUser){
        return RegisterMerchantDTO.builder().userName(newUser.getUserName())
                .firstName(newUser.getFirstName())
                .lastName(newUser.getLastName())
                .password(newUser.getPassword())
                .email(newUser.getEmail())
                .homeAddress(newUser.getHomeAddress())
                .phoneNumber(newUser.getPhoneNumber())
                .idNumber(newUser.getIdNumber())
                .idType(newUser.getIdType())
                .sex(newUser.getSex())
                .role(newUser.getRole()).merchant(newUser.getMerchant()).build();
    }

    public Users RegisterMerchantDtoToUsers(RegisterMerchantDTO newUser){
        return Users.builder().userName(newUser.getUserName())
                .firstName(newUser.getFirstName())
                .lastName(newUser.getLastName())
                .password(newUser.getPassword())
                .email(newUser.getEmail())
                .homeAddress(newUser.getHomeAddress())
                .phoneNumber(newUser.getPhoneNumber())
                .idNumber(newUser.getIdNumber())
                .idType(newUser.getIdType())
                .sex(newUser.getSex())
                .role(newUser.getRole()).merchant(newUser.getMerchant()).build();
    }
}
