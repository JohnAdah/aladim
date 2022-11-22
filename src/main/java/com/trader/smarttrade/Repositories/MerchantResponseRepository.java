package com.trader.smarttrade.Repositories;

import com.trader.smarttrade.Entities.MerchantResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MerchantResponseRepository extends JpaRepository<MerchantResponse,String> {

    @Query(" from MerchantResponse where user.userId = :user_id")
    List<MerchantResponse> findAllByUserId(@Param("user_id") String userId);

    @Query(" from MerchantResponse where request.requestId = :req_id")
    List<MerchantResponse> findAllByRequestId(@Param("req_id") String requestId);

    @Query(" from MerchantResponse where responseId = :res_id")
    MerchantResponse findByResponseId(@Param("res_id") String responseId);
}
