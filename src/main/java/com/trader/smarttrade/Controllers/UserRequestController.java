package com.trader.smarttrade.Controllers;

import com.trader.smarttrade.DTOs.MerchantResponseDTO;
import com.trader.smarttrade.DTOs.UserRequestDTO;
import com.trader.smarttrade.Entities.UserRequest;
import com.trader.smarttrade.Entities.Users;
import com.trader.smarttrade.Services.UserRequestService;
import com.trader.smarttrade.Utils.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Controller
public class UserRequestController {

    private static final Logger log= LoggerFactory.getLogger(UserRequestController.class);

    @Autowired
    private UserRequestService userRequestService;


    //Handler for creating new requests by the user
    @GetMapping("/user/request")
    public String newRequest(Model model){
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        model.addAttribute("requestObject",userRequestDTO);
        return "/user/request";
    }


    //Handler method to handle the post request from the new-request webpage
    @PostMapping("/user/new/request")
    public String postRequest(@ModelAttribute UserRequestDTO request,
                              Model model,@RequestParam("file") MultipartFile file) throws IOException {

        UserRequest dbRequest = userRequestService.newRequest(request, file);
        List<UserRequestDTO> requestDTO = userRequestService
                .allUserRequests(dbRequest.getUser().getUserId());
        model.addAttribute("requestKey",requestDTO);
        return "/user/allrequests";
    }

    //
    @GetMapping("/user/allrequests")
    public String allRequests(Model model){
        List<UserRequestDTO> requestDTO = userRequestService.allUserRequests("USR211122100045169");
        model.addAttribute("requestKey",requestDTO);
        return "/user/allrequests";
    }

    @GetMapping("/user/view/details/request/{requestId}/view")
    public String viewDetailsOfRequest(@PathVariable("requestId") String requestId, Model model)  {
        log.info("This is the controller");
        UserRequestDTO request = userRequestService.FetchOneRequest(requestId);
        //log.info(request.getImageUrl());
        model.addAttribute("requestKey",request);
        return "/user/details";
    }

    @GetMapping("/user/view/merchant/responses/{requestId}/view")
    public String allResponses(@PathVariable("requestId") String requestId, Model model){
        List<MerchantResponseDTO> responseDTO =  userRequestService.viewResponses(requestId);
        model.addAttribute("key", responseDTO);
        return "user/merchant-responses";
    }

    @GetMapping("/user/view/details/response/{responseId}")
    public String responseDetail(@PathVariable("responseId") String responseId, Model model){
        MerchantResponseDTO response = userRequestService.viewOneResponse(responseId);
        model.addAttribute("response",response);
        return "user/response-details";
    }

}
