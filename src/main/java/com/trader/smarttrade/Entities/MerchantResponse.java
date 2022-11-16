package com.trader.smarttrade.Entities;

import com.trader.smarttrade.Utils.IdGenerator;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "merchant_response")
public class MerchantResponse {
    @Id
    @Column(name = "response_id")
    private String responseId;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Users user;

    @ManyToOne()
    @JoinColumn(name = "request_id",referencedColumnName = "request_id")
    private UserRequest request;

    @CreationTimestamp
    @Column(name = "date")
    private LocalDate responseDate;

    @Column(name = "price")
    private Double responsePrice;

    @Column(name = "description", length = 512)
    private String responseDescription;

    @Column(name = "image_url")
    private byte[] imageUrl;

    public MerchantResponse() {
        String prefix = "RS";
        this.responseId = IdGenerator.customIdGenerator(prefix,600,800);
    }
}
