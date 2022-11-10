package com.trader.smarttrade.Repositories;

import com.trader.smarttrade.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,String> {
}
