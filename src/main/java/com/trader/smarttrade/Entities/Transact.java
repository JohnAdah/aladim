package com.trader.smarttrade.Entities;

import com.trader.smarttrade.Enums.PaymentStatus;
import com.trader.smarttrade.Enums.PaymentType;
import com.trader.smarttrade.Enums.TransactionStatus;
import com.trader.smarttrade.Utils.IdGenerator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity

@Table(name = "Transact")
public class Transact {
    @Id
    @Column(name = "transaction_id")
    private String transactionId;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_request", referencedColumnName = "request_id")
    private UserRequest userRequest;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "merchant_response", referencedColumnName = "response_id")
    private MerchantResponse merchantResponse;

    @Column(name = "payment_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Column(name = "initiated_Date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date initiatedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false)
    private PaymentStatus paymentConfirmationStatus;


    @Column(name = "confirmed_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-mm-yy HH:MM")
    private Date confirmationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_status", nullable = false)
    private TransactionStatus transactionStatus;

    @ManyToOne()
    @JoinColumn(name = "wallet_id", referencedColumnName = "wallet_id")
    private Wallet wallet;

    public Transact(){
        this.transactionId = IdGenerator.transactionIdGenerator("TRN0");
    }


}
