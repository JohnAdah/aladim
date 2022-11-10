package com.trader.smarttrade.Services.Implementation;

import com.trader.smarttrade.Entities.Users;
import com.trader.smarttrade.Services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImplementation implements UserService {


    @Override
    public void CreateUser(Users userDto, String role) {
            if(role == "USER"){

            }
    }

    @Override
    public void UpdateUser(Users user) {

    }

    @Override
    public Users GetUser(String id) {
        return null;
    }

    @Override
    public List<Users> GetAllUsers() {
        return null;
    }

    @Override
    public String DeleteUser(String id) {
        return null;
    }
}
