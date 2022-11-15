package com.trader.smarttrade.Repositories;

import com.trader.smarttrade.Entities.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRequestRepository extends JpaRepository<UserRequest,String>{
    @Query(" from UserRequest where user.userId = :user_id")
    List<UserRequest> findAllById(@Param("user_id") String userId);

}
