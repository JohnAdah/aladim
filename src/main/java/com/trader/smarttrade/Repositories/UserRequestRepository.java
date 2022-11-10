package com.trader.smarttrade.Repositories;

import com.trader.smarttrade.Entities.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRequestRepository extends JpaRepository<UserRequest,String>{
}
