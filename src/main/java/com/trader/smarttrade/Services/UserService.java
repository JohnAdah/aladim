package com.trader.smarttrade.Services;

import com.trader.smarttrade.Entities.Users;
import org.springframework.stereotype.Component;

import java.util.List;


public interface UserService {
        void CreateUser(Users user, String role);
        void UpdateUser(Users user);
        Users GetUser(String id);
        List<Users> GetAllUsers();
        String DeleteUser(String id);
}
