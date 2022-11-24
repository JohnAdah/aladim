package com.trader.smarttrade.Services.Implementation;

import com.trader.smarttrade.DTOs.MerchantResponseDTO;
import com.trader.smarttrade.DTOs.UserRequestDTO;
import com.trader.smarttrade.Entities.*;
import com.trader.smarttrade.Mapper.MerchantResponseMapper;
import com.trader.smarttrade.Mapper.UserRequestMapper;
import com.trader.smarttrade.Repositories.MerchantResponseRepository;
import com.trader.smarttrade.Repositories.UserRepository;
import com.trader.smarttrade.Repositories.UserRequestRepository;
import com.trader.smarttrade.Services.UserRequestService;
import com.trader.smarttrade.Utils.IdGenerator;
import com.trader.smarttrade.Utils.SaveImage;
import com.trader.smarttrade.Utils.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserRequestServiceImplementation implements UserRequestService {

    private static final Logger log= LoggerFactory.getLogger(UserRequestServiceImplementation.class);
    private UserRequestRepository userRequestRepo;

    private MerchantResponseRepository merchantRepo;

    private UserRepository userRepo;



    public UserRequestServiceImplementation(UserRequestRepository userRequestRepo,
                                            MerchantResponseRepository merchantRepo,
                                            UserRepository userRepo) {
        this.userRequestRepo = userRequestRepo;
        this.merchantRepo = merchantRepo;
        this.userRepo = userRepo;
    }






    @Override
    public UserRequest newRequest(UserRequestDTO userRequestDTO, MultipartFile file) throws IOException {
        String prefix = "RQ";
        String requestId = IdGenerator.customIdGenerator(prefix,200,300);
        userRequestDTO.setRequestId(requestId);

        String email = SecurityUtils.getCurrentUser().getUsername();
        Users user = userRepo.findByEmail(email);

        UserRequest dbUserRequest = UserRequestMapper.UserRequestDtoToUserRequest(userRequestDTO);
        dbUserRequest.setUser(user);
        dbUserRequest.setImageUrl(SaveImage.imagePath(file));
        userRequestRepo.save(dbUserRequest);
        return dbUserRequest;
    }

    @Override
    public List<UserRequestDTO> allUserRequests(String userId)
    {
        String email = SecurityUtils.getCurrentUser().getUsername();
        Users user = userRepo.findByEmail(email);

        userId  = user.getUserId();

        List<UserRequest> allUserRequest = userRequestRepo.findAllById(userId);

        return allUserRequest.stream().map(UserRequestMapper::UserRequestToUserRequestDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserRequestDTO FetchOneRequest(String id) {
        log.info("This is the userRequestservice");
        Optional<UserRequest> request = Optional.of(userRequestRepo.findById(id)
                .orElseThrow());
        UserRequestDTO requestDto = UserRequestMapper
                .UserRequestToUserRequestDto(request.orElseThrow());
        log.info("This is the 2nd userRequestservice");
        return requestDto;
    }

    @Override
    public List<MerchantResponseDTO> viewResponses(String requestId) {
        List<MerchantResponse> response = merchantRepo.findAllByRequestId(requestId);
        return response.stream()
                .map(MerchantResponseMapper::MerchantResponseToMerchantResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Transact makeTransaction() {
        return null;
    }

    @Override
    public Wallet creditWallet() {
        return null;
    }

    @Override
    public MerchantResponseDTO viewOneResponse(String responseId) {
        MerchantResponse response = merchantRepo.findByResponseId(responseId);
        MerchantResponseDTO responseDTO = MerchantResponseMapper
                .MerchantResponseToMerchantResponseDTO(response);
        return responseDTO;
    }
}
