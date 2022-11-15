package com.trader.smarttrade.Services.Implementation;

import com.trader.smarttrade.DTOs.UserDTO;
import com.trader.smarttrade.Entities.Users;
import com.trader.smarttrade.Entities.Wallet;
import com.trader.smarttrade.Mapper.UsersMapper;
import com.trader.smarttrade.Repositories.UserRepository;
import com.trader.smarttrade.Services.UserService;
import com.trader.smarttrade.Services.WalletService;
import com.trader.smarttrade.Utils.IdGenerator;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImplementation implements UserService {


    private UserRepository userRepo;

    public UserServiceImplementation(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void CreateUser(UserDTO user) {
        String prefix = "USR";
        String userId = IdGenerator.customIdGenerator(prefix,100,200);
        user.setUserId(userId);

        Long walletId = IdGenerator.customWalletIdGenerator();
        Wallet wallet = new Wallet();
        wallet.setWalletId(walletId);
        wallet.setWalletAmount(0.00);

        Users dbUser = UsersMapper.UsersDtoToUsers(user);
        dbUser.setWallet(wallet);

        userRepo.save(dbUser);
    }


    @Override
    public void UpdateUser(Users user) {

    }

    @Override
    public Users GetUser(String id) {
        return null;
    }

    @Override
    public List<Users>  GetAllUsers() {
        return null;
    }

    @Override
    public String DeleteUser(String id) {
        return null;
    }
}
