package com.trader.smarttrade.Mapper;

import com.trader.smarttrade.DTOs.WalletDTO;
import com.trader.smarttrade.Entities.Wallet;

public class WalletMapper {

    public static WalletDTO walletToWalletDto(Wallet wallet){
        return WalletDTO.builder().walletId(wallet.getWalletId())
                .walletAmount(wallet.getWalletAmount()).build();
    }

    public static Wallet walletDtoToWallet(WalletDTO walletDTO){
        return Wallet.builder().walletId(walletDTO.getWalletId())
                .walletAmount(walletDTO.getWalletAmount()).build();
    }
}
