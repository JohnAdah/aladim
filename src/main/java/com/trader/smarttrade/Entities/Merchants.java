package com.trader.smarttrade.Entities;


import com.trader.smarttrade.Enums.MerchantCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "merchants")

public class Merchants {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    //Merchant id references the userID in the users table
    @OneToOne(mappedBy = "merchant")
    private Users user_id;

    @Column(name = "business_name")
    private String BusinessName;

    @Column(name = "merchant_category")
    @Enumerated(EnumType.STRING)
    private MerchantCategory merchantCategory;

    @Column(name = "cac_registration_number")
    private String cacRegistrationNumber;

    @Column(name = "bvn")
    private Long bvn;


    //private String userId;
}
