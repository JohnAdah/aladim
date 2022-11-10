package com.trader.smarttrade.Repositories;

import com.trader.smarttrade.Entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Long> {
}
