package com.trader.smarttrade.Entities;

import com.trader.smarttrade.Utils.IdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "merchant_response")
public class MerchantResponse {
    @Id
    @Column(name = "response_id")
    private String responseId;

    @ManyToOne()
    @JoinColumn(name = "request_id",referencedColumnName = "request_id")
    private UserRequest request_Id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private LocalDate responseDate;

    @Column(name = "price")
    private Double responsePrice;

    @Column(name = "description", length = 512)
    private String responseDescription;

    @ManyToOne()
    @JoinColumn(name = "merchant_id", referencedColumnName = "id")
    private Merchants merchant;

    @Column(name = "image_url")
    private String imageUrl;

    public MerchantResponse() {
        String prefix = "RS";
        this.responseId = IdGenerator.customIdGenerator(prefix,600,800);
    }
}
