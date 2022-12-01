package com.trader.smarttrade.Controllers;

import com.trader.smarttrade.Entities.Users;
import com.trader.smarttrade.Services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/merchant/view/profile")
    public String viewMerchantProfile(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String obj = auth.getName();
        Users dbUser = userService.findByEmail(obj);
        model.addAttribute("user",dbUser);
        return "/merchant/view-profile";
    }

    @GetMapping("/user/view/profile")
    public String viewUserProfile(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String obj = auth.getName();
        Users dbUser = userService.findByEmail(obj);
        model.addAttribute("user",dbUser);
        return "/user/view-profile";
    }

}
