package com.trader.smarttrade.Controllers;

import com.trader.smarttrade.DTOs.UserDTO;
import com.trader.smarttrade.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {


    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    //Handler method for User Registration for both User
    @GetMapping("/registration")
    public String registration(Model model){
        UserDTO newUser = new UserDTO();
        model.addAttribute("registerUser",newUser);
        return "/registration";
    }

    //Handler method to handle the submission of the registration form.
    @PostMapping("/user/register")
    public String resultRegistration(@ModelAttribute UserDTO userdto,Model model){
        userService.CreateUser(userdto);
        model.addAttribute("registered",userdto);
        return "/successful";
    }



}
