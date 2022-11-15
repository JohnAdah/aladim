package com.trader.smarttrade.Services.Implementation;

import com.trader.smarttrade.DTOs.MerchantResponseDTO;
import com.trader.smarttrade.DTOs.UserRequestDTO;
import com.trader.smarttrade.Entities.MerchantResponse;
import com.trader.smarttrade.Entities.Transact;
import com.trader.smarttrade.Entities.UserRequest;
import com.trader.smarttrade.Mapper.UserRequestMapper;
import com.trader.smarttrade.Repositories.MerchantResponseRepository;
import com.trader.smarttrade.Repositories.UserRequestRepository;
import com.trader.smarttrade.Services.MerchantResponseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MerchantResponseServiceImplementation implements MerchantResponseService {

    private MerchantResponseRepository merchantRepo;
    private UserRequestRepository userRepo;

    public MerchantResponseServiceImplementation(MerchantResponseRepository merchantRepo,
                                                 UserRequestRepository userRepo){
        this.merchantRepo = merchantRepo;
        this.userRepo = userRepo;
    }


    @Override
    public MerchantResponse respond(MerchantResponseDTO responseDTO) {

        return null;
    }

    @Override
    public List<UserRequestDTO> viewRequests() {
        List<UserRequest> userRequestDTOList = userRepo.findAll();
        return userRequestDTOList.stream().map(UserRequestMapper::UserRequestToUserRequestDto)
                .collect(Collectors.toList());
    }

    @Override
    public Transact confirmTransaction() {
        return null;
    }
}
