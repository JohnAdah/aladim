package com.trader.smarttrade.Repositories;

import com.trader.smarttrade.Entities.Transact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactRepository extends JpaRepository<Transact, String> {
}
