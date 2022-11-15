package com.trader.smarttrade.Controllers;

import com.trader.smarttrade.DTOs.UserRequestDTO;
import com.trader.smarttrade.Entities.UserRequest;
import com.trader.smarttrade.Services.UserRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserRequestController {

    @Autowired
    private UserRequestService userRequestService;



    //Handler for creating new requests by the user
    @GetMapping("/request")
    public String newRequest(Model model){
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        model.addAttribute("requestObject",userRequestDTO);
        return "/request";
    }


    //Handler method to handle the post request from the new-request webpage
    @PostMapping("/new/request")
    public String postRequest(@ModelAttribute UserRequestDTO request, Model model){
        UserRequest dbRequest = userRequestService.newRequest(request);
        List<UserRequestDTO> requestDTO = userRequestService.allUserRequests(dbRequest.getUser().getUserId());
        model.addAttribute("requestKey",requestDTO);
        return "/allrequests";
    }


}
