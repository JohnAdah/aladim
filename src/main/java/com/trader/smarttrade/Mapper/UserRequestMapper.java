package com.trader.smarttrade.Mapper;

import com.trader.smarttrade.DTOs.UserRequestDTO;
import com.trader.smarttrade.Entities.UserRequest;

public class UserRequestMapper {

    public static UserRequestDTO UserRequestToUserRequestDto(UserRequest request){
        return UserRequestDTO.builder().requestId(request.getRequestId())
                .title(request.getTitle())
                .user(request.getUser())
                .requestMaxPrice(request.getRequestMaxPrice())
                .requestMinPrice(request.getRequestMinPrice())
                .imageUrl(request.getImageUrl())
                .category(request.getCategory())
                .description(request.getDescription())
                .requestDate(request.getRequestDate()).updatedDate(request.getUpdatedDate()).build();
    }

    public static UserRequest UserRequestDtoToUserRequest(UserRequestDTO userRequestDTO){
        return UserRequest.builder().requestId(userRequestDTO.getRequestId())
                .title(userRequestDTO.getTitle())
                .user(userRequestDTO.getUser())
                .requestMaxPrice(userRequestDTO.getRequestMaxPrice())
                .requestMinPrice(userRequestDTO.getRequestMinPrice())
                .imageUrl(userRequestDTO.getImageUrl())
                .category(userRequestDTO.getCategory())
                .description(userRequestDTO.getDescription())
                .requestDate(userRequestDTO.getRequestDate())
                .updatedDate(userRequestDTO.getUpdatedDate()).build();
    }
}
