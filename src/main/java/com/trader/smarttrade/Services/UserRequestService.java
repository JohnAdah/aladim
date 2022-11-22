package com.trader.smarttrade.Services;

import com.trader.smarttrade.DTOs.MerchantResponseDTO;
import com.trader.smarttrade.DTOs.UserRequestDTO;
import com.trader.smarttrade.Entities.MerchantResponse;
import com.trader.smarttrade.Entities.Transact;
import com.trader.smarttrade.Entities.UserRequest;
import com.trader.smarttrade.Entities.Wallet;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
public interface UserRequestService {
    UserRequest newRequest(UserRequestDTO request, MultipartFile file) throws IOException;

    List<UserRequestDTO> allUserRequests(String Id);


    UserRequestDTO FetchOneRequest(String id);

    List<MerchantResponseDTO> viewResponses(String requestId);
    Transact makeTransaction();

    Wallet creditWallet();

    MerchantResponseDTO viewOneResponse(String responseId);
}
