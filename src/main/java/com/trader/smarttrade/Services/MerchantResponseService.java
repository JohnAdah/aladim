package com.trader.smarttrade.Services;

import com.trader.smarttrade.DTOs.MerchantResponseDTO;
import com.trader.smarttrade.DTOs.UserRequestDTO;
import com.trader.smarttrade.Entities.MerchantResponse;
import com.trader.smarttrade.Entities.Transact;
import com.trader.smarttrade.Entities.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MerchantResponseService {

    MerchantResponse respond(MerchantResponseDTO response);
    List<UserRequestDTO> viewRequests();
    Transact confirmTransaction();

}
