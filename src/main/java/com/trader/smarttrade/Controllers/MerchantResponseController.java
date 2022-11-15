package com.trader.smarttrade.Controllers;

import com.trader.smarttrade.DTOs.UserRequestDTO;
import com.trader.smarttrade.Services.MerchantResponseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MerchantResponseController {

    private MerchantResponseService merchantResponseService;

    public MerchantResponseController(MerchantResponseService merchantResponseService){
        this.merchantResponseService = merchantResponseService;
    }

    @GetMapping("/merchant/view/request")
    public String viewAllRequest(Model model){
        List<UserRequestDTO> request = merchantResponseService.viewRequests();
        model.addAttribute("viewRequest",request);
        return "/merchant-view-requests";
    }
}
