package com.trader.smarttrade.Services;

import com.trader.smarttrade.DTOs.WalletDTO;
import com.trader.smarttrade.Entities.Wallet;

public interface WalletService {

    void createWallet(WalletDTO walletDTO);
}
