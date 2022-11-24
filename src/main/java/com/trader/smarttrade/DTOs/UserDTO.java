package com.trader.smarttrade.DTOs;


import com.sun.istack.NotNull;
import com.trader.smarttrade.Entities.Address;
import com.trader.smarttrade.Entities.Role;
import com.trader.smarttrade.Enums.IdentityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String userId;

    @NotEmpty
    private String userName;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;

    @NotEmpty(message = "Password cannot be Empty")
    private String password;

    @NotEmpty(message = "A mobile number is needed")
    private String phoneNumber;

    private IdentityType idType;

    private Long idNumber;

    private Address homeAddress;

    private List<Role> role;

}
