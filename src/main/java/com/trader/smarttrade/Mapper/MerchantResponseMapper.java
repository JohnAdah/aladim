package com.trader.smarttrade.Mapper;

import com.trader.smarttrade.DTOs.MerchantResponseDTO;
import com.trader.smarttrade.Entities.MerchantResponse;

public class MerchantResponseMapper {
    public static MerchantResponse MerchantResponseDtoToMerchantResponse(MerchantResponseDTO response){
        return MerchantResponse.builder().responseId(response.getResponseId())
                .responseDescription(response.getResponseDescription())
                .responsePrice(response.getResponsePrice())
                .responseDate(response.getResponseDate())
                .user(response.getUser())
                .imageUrl(response.getImageUrl())
                .request(response.getRequest())
                .updatedDate(response.getUpdatedDate()).build();
    }


    public static MerchantResponseDTO MerchantResponseToMerchantResponseDTO(MerchantResponse response){
        return MerchantResponseDTO.builder().responseId(response.getResponseId())
                .responseDescription(response.getResponseDescription())
                .responsePrice(response.getResponsePrice())
                .responseDate(response.getResponseDate())
                .user(response.getUser())
                .imageUrl(response.getImageUrl())
                .request(response.getRequest())
                .updatedDate(response.getUpdatedDate()).build();
    }
}
