package com.trader.smarttrade.Security;

import com.trader.smarttrade.Entities.Users;
import com.trader.smarttrade.Repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private UserRepository userRepo;

    public CustomUserDetailService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepo.findByEmail(email);
        if(user != null){
            org.springframework.security.core.userdetails.User authenticateUser =
                    new org.springframework.security.core.userdetails.User(
                            user.getEmail(),
                            user.getPassword(),
                            user.getRoles().stream()
                                    .map(roles -> new SimpleGrantedAuthority(roles.getName()))
                                    .collect(Collectors.toList())
                    );
            return authenticateUser;
        }else{
            throw new UsernameNotFoundException("Invalid Username and Password");
        }
    }
}
