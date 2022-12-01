package com.trader.smarttrade.Utils;


import com.trader.smarttrade.Entities.Users;
import com.trader.smarttrade.Repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class SecurityUtils {

    private static UserRepository userRepo;

    public SecurityUtils(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public static User getCurrentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(principal instanceof User){
            return (User) principal;
        }return null;
    }

    public static String getCurrentUserFirstName(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user = null;
        if(principal instanceof User){
            user = userRepo.findByEmail(((User) principal).getUsername());
        }return user.getFirstName();
    }

}
