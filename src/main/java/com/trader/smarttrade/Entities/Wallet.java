package com.trader.smarttrade.Entities;

import com.trader.smarttrade.Utils.IdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    @Column(name = "wallet_id")
    private Long walletId;

    @Column(name = "balance")
    private Double walletAmount;
//
//    @OneToOne()
//    private Users user;

    @OneToMany(mappedBy = "wallet_id", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Transact> transact;

    public Wallet(){
        this.walletId = IdGenerator.customWalletIdGenerator();
        this.walletAmount = 0.00;
    }

}
