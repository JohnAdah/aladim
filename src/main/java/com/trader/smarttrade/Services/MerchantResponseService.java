package com.trader.smarttrade.Services;

import com.trader.smarttrade.DTOs.MerchantResponseDTO;
import com.trader.smarttrade.DTOs.UserRequestDTO;
import com.trader.smarttrade.Entities.MerchantResponse;
import com.trader.smarttrade.Entities.Transact;
import com.trader.smarttrade.Entities.UserRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Service
public interface MerchantResponseService {

    MerchantResponse respond(MerchantResponseDTO response, MultipartFile file) throws IOException;
    List<UserRequestDTO> viewRequests();

    UserRequestDTO viewOneRequest(String id);
    MerchantResponse updateResponse(MerchantResponseDTO response, MultipartFile file);

    Transact confirmTransaction();

    List<MerchantResponseDTO> viewAllResponses(String id);

    MerchantResponseDTO viewOneResponse(String responseId);

    void deleteResponse(String id);
}
