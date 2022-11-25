package com.trader.smarttrade.Controllers;

import com.trader.smarttrade.DTOs.UserDTO;
import com.trader.smarttrade.Entities.Users;
import com.trader.smarttrade.Services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {


    private UserService userService;

    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }


    //Handler to get to the homepage
    @GetMapping("/")
    public String homePage(){
        return "/home";
    }

    //Handler to get the login page
    @GetMapping("/login")
    public String loginPage(Model model)
    {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("loginKey", userDTO);
        return "/login";
    }

    @GetMapping("/render/user/page")
    public String returnUserPage(@ModelAttribute UserDTO userDTO,
                                 Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String obj = auth.getName();
        Users dbUser = userService.findByEmail(obj);
        model.addAttribute("userKey",dbUser);
        if(dbUser.getRoles().stream().anyMatch(role -> role.getName().equals("BUYER"))){

            return "/user/dashboard";
        }else if(dbUser.getRoles().stream().anyMatch(role -> role.getName().equals("MERCHANT"))){

            return "/merchant/dashboard";
        }else

            return "/admin/dashboard";
    }


    //Handler Method to handle merchant Registration
    @GetMapping("register/merchant")
    public String showRegistrationMerchantPage(Model model){
        UserDTO userDTO = new UserDTO();
        model.addAttribute("registerUser",userDTO);
        return "merchant/merchant-registration";
    }

    @PostMapping("/register/merchant")
    public String registerMerchant(@Valid @ModelAttribute("userDTO") UserDTO userDTO,
                                   BindingResult result,
                                   Model model){
        Users userExist = userService.findByEmail(userDTO.getEmail());
        if(userExist != null && userExist.getEmail() != null){
            result.rejectValue("email",null,"The User already exist");
        }
        if(result.hasErrors()){
            model.addAttribute("userDTO",userDTO);
            return "merchant/merchant-registration";
        }
        userService.CreateMerchant(userDTO);
        return "/successful";
    }

    //HANDLER method to handle the User registration
    @GetMapping("register/buyer")
    public String showRegistrationBuyerPage(Model model){
        UserDTO userDTO = new UserDTO();
        model.addAttribute("registerUser",userDTO);
        return "user/user-registration";
    }

    @PostMapping("/register/buyer")
    public String registerBuyer(@Valid @ModelAttribute("userDTO") UserDTO userDTO,
                                BindingResult result,
                                Model model){
        Users userExist = userService.findByEmail(userDTO.getEmail());
        if(userExist != null && userExist.getEmail() != null){
            result.rejectValue("email",null,"The User already exist");
        }
        if(result.hasErrors()){
            model.addAttribute("registerUser",userDTO);
            return "user/user-registration";
        }
        userService.CreateBuyer(userDTO);
        return "/successful";
    }

}
