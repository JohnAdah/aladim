package com.trader.smarttrade.Services;

import com.trader.smarttrade.DTOs.UserDTO;
import com.trader.smarttrade.Entities.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
        void CreateBuyer(UserDTO user);

    void UpdateUser(Users user);
        UserDTO GetUser(String id);
        List<Users> GetAllUsers();
        String DeleteUser(String id);

    Users findByEmail(String email);

    void CreateMerchant(UserDTO userDTO);

}
