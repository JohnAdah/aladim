package com.trader.smarttrade.Services.Implementation;

import com.trader.smarttrade.DTOs.UserRequestDTO;
import com.trader.smarttrade.Entities.*;
import com.trader.smarttrade.Mapper.UserRequestMapper;
import com.trader.smarttrade.Repositories.UserRequestRepository;
import com.trader.smarttrade.Services.UserRequestService;
import com.trader.smarttrade.Utils.IdGenerator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRequestServiceImplementation implements UserRequestService {

    private UserRequestRepository userRequestRepo;

    public UserRequestServiceImplementation(UserRequestRepository userRequestRepo) {
        this.userRequestRepo = userRequestRepo;
    }

    @Override
    public UserRequest newRequest(UserRequestDTO userRequestDTO) {
        String prefix = "RQ";
        String requestId = IdGenerator.customIdGenerator(prefix,200,300);
        userRequestDTO.setRequestId(requestId);

        Users user = new Users();
        user.setUserId("USR131122150312175");

        UserRequest dbUserRequest = UserRequestMapper.UserRequestDtoToUserRequest(userRequestDTO);
        dbUserRequest.setUser(user);
        userRequestRepo.save(dbUserRequest);
        return dbUserRequest;
    }

    @Override
    public List<UserRequestDTO> allUserRequests(String userId)
    {
        List<UserRequest> allUserRequest = userRequestRepo.findAllById(userId);

        return allUserRequest.stream().map(UserRequestMapper::UserRequestToUserRequestDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MerchantResponse> viewResponses() {
        return null;
    }

    @Override
    public Transact makeTransaction() {
        return null;
    }

    @Override
    public Wallet creditWallet() {
        return null;
    }
}
