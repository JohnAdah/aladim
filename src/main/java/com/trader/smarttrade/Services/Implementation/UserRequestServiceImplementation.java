package com.trader.smarttrade.Services.Implementation;

import com.trader.smarttrade.DTOs.UserRequestDTO;
import com.trader.smarttrade.Entities.*;
import com.trader.smarttrade.Exceptions.ResourceNotFoundException;
import com.trader.smarttrade.Mapper.UserRequestMapper;
import com.trader.smarttrade.Repositories.UserRequestRepository;
import com.trader.smarttrade.Services.UserRequestService;
import com.trader.smarttrade.Utils.IdGenerator;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserRequestServiceImplementation implements UserRequestService {

    private UserRequestRepository userRequestRepo;

    public UserRequestServiceImplementation(UserRequestRepository userRequestRepo) {
        this.userRequestRepo = userRequestRepo;
    }

    @Override
    public UserRequest newRequest(UserRequestDTO userRequestDTO, MultipartFile file) {
        String prefix = "RQ";
        String requestId = IdGenerator.customIdGenerator(prefix,200,300);
        userRequestDTO.setRequestId(requestId);

        Users user = new Users();
        user.setUserId("USR161122130343121");

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a valid file");
        }
        try {
            userRequestDTO.setImageUrl(Base64.getEncoder().encode(file.getBytes()));//encodeToString(file.getBytes()).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

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
    public UserRequestDTO FetchOneRequest(String id) {
        Optional<UserRequest> request = Optional.of(userRequestRepo.findById(id)
                .orElseThrow());
        UserRequestDTO requestDto = UserRequestMapper
                .UserRequestToUserRequestDto(request.orElseThrow());
        return requestDto;
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
