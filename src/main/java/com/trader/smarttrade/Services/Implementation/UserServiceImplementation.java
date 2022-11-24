package com.trader.smarttrade.Services.Implementation;

import com.trader.smarttrade.DTOs.UserDTO;
import com.trader.smarttrade.Entities.Role;
import com.trader.smarttrade.Entities.Users;
import com.trader.smarttrade.Entities.Wallet;
import com.trader.smarttrade.Mapper.UsersMapper;
import com.trader.smarttrade.Repositories.RoleRepository;
import com.trader.smarttrade.Repositories.UserRepository;
import com.trader.smarttrade.Services.UserService;
import com.trader.smarttrade.Utils.IdGenerator;
import com.trader.smarttrade.Utils.SecurityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class UserServiceImplementation implements UserService {


    private UserRepository userRepo;
    private RoleRepository roleRepo;

    private PasswordEncoder passwordEncoder;

    private static final String prefix = "USR";


    public UserServiceImplementation(UserRepository userRepo,
                                     RoleRepository roleRepository,
                                     PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void CreateBuyer(UserDTO user) {
        String userId = IdGenerator.customIdGenerator(prefix,100,200);
        user.setUserId(userId);

        Long walletId = IdGenerator.customWalletIdGenerator();
        Wallet wallet = new Wallet();
        wallet.setWalletId(walletId);
        wallet.setWalletAmount(0.00);

        Role role = roleRepo.findByName("BUYER");

        Users dbUser = UsersMapper.UsersDtoToUsers(user);
        dbUser.setPassword(passwordEncoder.encode(dbUser.getPassword()));
        dbUser.setWallet(wallet);
        dbUser.setRoles(Arrays.asList(role));

        userRepo.save(dbUser);
    }


    @Override
    public void CreateMerchant(UserDTO userDTO) {
        String userId = IdGenerator.customIdGenerator(prefix,100,200);
        userDTO.setUserId(userId);

        Long walletId = IdGenerator.customWalletIdGenerator();
        Wallet wallet = new Wallet();
        wallet.setWalletId(walletId);
        wallet.setWalletAmount(0.00);

        Role role = roleRepo.findByName("MERCHANT");

        Users dbUser = UsersMapper.UsersDtoToUsers(userDTO);
        dbUser.setWallet(wallet);
        dbUser.setPassword(passwordEncoder.encode(dbUser.getPassword()));
        dbUser.setRoles(Arrays.asList(role));

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

    @Override
    public Users findByEmail(String email) {
        return userRepo.findByEmail(email);
    }


}
