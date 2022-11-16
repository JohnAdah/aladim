package com.trader.smarttrade.Services;

import com.trader.smarttrade.DTOs.UserRequestDTO;
import com.trader.smarttrade.Entities.MerchantResponse;
import com.trader.smarttrade.Entities.Transact;
import com.trader.smarttrade.Entities.UserRequest;
import com.trader.smarttrade.Entities.Wallet;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface UserRequestService {
    UserRequest newRequest(UserRequestDTO request, MultipartFile file);

    List<UserRequestDTO> allUserRequests(String Id);

    UserRequestDTO FetchOneRequest(String id);

    List<MerchantResponse> viewResponses();
    Transact makeTransaction();

    Wallet creditWallet();
}
