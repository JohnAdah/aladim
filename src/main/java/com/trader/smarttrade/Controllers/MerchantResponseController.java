package com.trader.smarttrade.Controllers;

import com.trader.smarttrade.DTOs.MerchantResponseDTO;
import com.trader.smarttrade.DTOs.UserRequestDTO;
import com.trader.smarttrade.Entities.MerchantResponse;
import com.trader.smarttrade.Entities.UserRequest;
import com.trader.smarttrade.Entities.Users;
import com.trader.smarttrade.Services.MerchantResponseService;
import com.trader.smarttrade.Services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class MerchantResponseController {

    private static final Logger log = LoggerFactory.getLogger(MerchantResponseController.class);

    private MerchantResponseService merchantResponseService;
    private UserService userService;

    public MerchantResponseController(MerchantResponseService merchantResponseService,
                                      UserService userService){
        this.merchantResponseService = merchantResponseService;
        this.userService = userService;
    }

    @GetMapping("/merchant/response/{requestId}")
    public String responseToRequest(@PathVariable("requestId") String requestId, Model model){
        log.info("Logging the request id @ 0: " + requestId);
        MerchantResponseDTO responseDTO = new MerchantResponseDTO();
        UserRequest request = new UserRequest();
        request.setRequestId(requestId);
        responseDTO.setRequest(request);
       // log.info("Logging the request id @ 1: " + responseDTO.getRequest().getRequestId());
        model.addAttribute("res",responseDTO);
        return "merchant/response";
    }


    @PostMapping ("/merchant/new/response")
    public String newResponse(@ModelAttribute MerchantResponseDTO response, Model model,
                              @RequestParam("requestId") String requestId,
                              @RequestParam("file") MultipartFile file) throws IOException {
        UserRequest request = new UserRequest();
        request.setRequestId(requestId);
        response.setRequest(request);
       // log.info("Logging the request id @ 2: " + response.toString());
        MerchantResponse merchantResponse = merchantResponseService.respond(response,file);
        log.info(merchantResponse.toString());
        List<MerchantResponseDTO> newResponseEntry = merchantResponseService
                .viewAllResponses(merchantResponse.getUser().getUserId());
        log.info(newResponseEntry.toString());
        model.addAttribute("res",newResponseEntry);
        return "/merchant/allresponse";
    }


    @GetMapping("/merchant/view/request")
    public String viewAllRequest(Model model){
        List<UserRequestDTO> request = merchantResponseService.viewRequests();
        model.addAttribute("viewRequest",request);
        return "merchant/merchant-view-requests";
    }

    @GetMapping("/merchant/request/{requestId}/detail")
    public String viewOneRequest(@PathVariable("requestId") String requestId, Model model){
        UserRequestDTO requestDTO = merchantResponseService.viewOneRequest(requestId);
        model.addAttribute("req",requestDTO);
        //log.info(requestDTO.getImageUrl());
        return "merchant/merchant-request-detail";
    }

    @GetMapping("merchant/view/details/response/{responseId}/view")
    public String viewOneResponseDetails(@PathVariable("responseId") String responseId, Model model){
        MerchantResponseDTO response = merchantResponseService.viewOneResponse(responseId);
        model.addAttribute("response",response);
        return "merchant/response-details";
    }


    @GetMapping("/merchant/all/response")
    public String viewAllResponses(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String obj = auth.getName();
        Users dbUser = userService.findByEmail(obj);
        List<MerchantResponseDTO> merchantResponseDTO = merchantResponseService
                .viewAllResponses(dbUser.getUserId());
        model.addAttribute("response",merchantResponseDTO);
        return "merchant/merchant-all-responses";
    }
}
