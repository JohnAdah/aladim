package com.trader.smarttrade.DTOs;


import com.trader.smarttrade.Entities.Address;
import com.trader.smarttrade.Enums.Gender;
import com.trader.smarttrade.Enums.IdentityType;
import com.trader.smarttrade.Enums.Roles;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class RegisterUserDTO {

    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Gender sex;

    private String phoneNumber;

    private IdentityType idType;

    private Long idNumber;

    private Address homeAddress;

    private Roles role;

}
