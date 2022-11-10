package com.trader.smarttrade.Repositories;

import com.trader.smarttrade.Entities.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchants,Integer> {
}
