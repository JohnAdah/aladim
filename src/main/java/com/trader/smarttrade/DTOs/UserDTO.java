package com.trader.smarttrade.DTOs;


import com.trader.smarttrade.Entities.Address;
import com.trader.smarttrade.Enums.IdentityType;
import com.trader.smarttrade.Enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String userId;

    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phoneNumber;

    private IdentityType idType;

    private Long idNumber;

    private Address homeAddress;

    private UserRole role;

}
