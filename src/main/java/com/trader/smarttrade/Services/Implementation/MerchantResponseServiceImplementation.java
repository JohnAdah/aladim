package com.trader.smarttrade.Services.Implementation;

import com.trader.smarttrade.DTOs.MerchantResponseDTO;
import com.trader.smarttrade.DTOs.UserRequestDTO;
import com.trader.smarttrade.Entities.MerchantResponse;
import com.trader.smarttrade.Entities.Transact;
import com.trader.smarttrade.Entities.UserRequest;
import com.trader.smarttrade.Entities.Users;
import com.trader.smarttrade.Mapper.MerchantResponseMapper;
import com.trader.smarttrade.Mapper.UserRequestMapper;
import com.trader.smarttrade.Repositories.MerchantResponseRepository;
import com.trader.smarttrade.Repositories.UserRepository;
import com.trader.smarttrade.Repositories.UserRequestRepository;
import com.trader.smarttrade.Services.MerchantResponseService;
import com.trader.smarttrade.Utils.IdGenerator;
import com.trader.smarttrade.Utils.SaveImage;
import com.trader.smarttrade.Utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MerchantResponseServiceImplementation implements MerchantResponseService {

    private MerchantResponseRepository merchantRepo;
    private UserRequestRepository requestRepository;

    private UserRepository userRepo;


    public MerchantResponseServiceImplementation(MerchantResponseRepository merchantRepo,
                                                 UserRequestRepository requestRepository,
                                                 UserRepository userRepo
                                                 ){
        this.merchantRepo = merchantRepo;
        this.requestRepository = requestRepository;
        this.userRepo = userRepo;
    }



    @Override
    public MerchantResponse respond(MerchantResponseDTO responseDTO, MultipartFile file) throws IOException {
        String prefix = "RS";
        String responseId = IdGenerator.customIdGenerator(prefix,600,800);
        responseDTO.setResponseId(responseId);

        String email = SecurityUtils.getCurrentUser().getUsername();
        Users user = userRepo.findByEmail(email);

        responseDTO.setUser(user);
        responseDTO.setImageUrl(SaveImage.imageResponsePath(file));
        MerchantResponse response = MerchantResponseMapper.MerchantResponseDtoToMerchantResponse(responseDTO);
        merchantRepo.save(response);
        return response;
    }

    @Override
    public List<UserRequestDTO> viewRequests() {
        List<UserRequest> userRequestDTOList = requestRepository.findAll();
        return userRequestDTOList.stream().map(UserRequestMapper::UserRequestToUserRequestDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserRequestDTO viewOneRequest(String id){
        Optional<UserRequest> request = Optional.of(requestRepository.findById(id).orElseThrow());
        UserRequestDTO requestDTO =  UserRequestMapper.UserRequestToUserRequestDto(request.orElseThrow());
        return requestDTO;
    }

    @Override
    public Transact confirmTransaction() {
        return null;
    }

    @Override
    public List<MerchantResponseDTO> viewAllResponses(String id) {
        List<MerchantResponse> responses = merchantRepo.findAllByUserId(id);
        return responses.stream().map(MerchantResponseMapper::MerchantResponseToMerchantResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MerchantResponseDTO viewOneResponse(String responseId) {
        Optional<MerchantResponse> response = Optional.of(Optional.of(
                merchantRepo.findById(responseId).get()).orElseThrow());
        MerchantResponseDTO responseDTO = MerchantResponseMapper
                .MerchantResponseToMerchantResponseDTO(response.orElseThrow());
        return responseDTO;
    }
}
