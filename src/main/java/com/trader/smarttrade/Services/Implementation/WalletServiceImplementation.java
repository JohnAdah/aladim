package com.trader.smarttrade.Services.Implementation;

import com.trader.smarttrade.DTOs.WalletDTO;
import com.trader.smarttrade.Entities.Wallet;
import com.trader.smarttrade.Mapper.WalletMapper;
import com.trader.smarttrade.Repositories.WalletRepository;
import com.trader.smarttrade.Services.WalletService;
import com.trader.smarttrade.Utils.IdGenerator;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImplementation implements WalletService{

    private WalletRepository walletRepository;

    public WalletServiceImplementation(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public void createWallet(WalletDTO walletDTO) {
        Long walletId =IdGenerator.customWalletIdGenerator();
        Double walletAmount = 0.00;
        walletDTO.setWalletId(walletId);
        walletDTO.setWalletAmount(walletAmount);
        Wallet wallet = WalletMapper.walletDtoToWallet(walletDTO);
        walletRepository.save(wallet);
    }
}
