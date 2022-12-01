package com.trader.smarttrade.Entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
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
    private Date responseDate;

    @UpdateTimestamp
    @Column(name = "modified_date")
    private Date updatedDate;

    @Column(name = "price")
    private Double responsePrice;

    @Column(name = "description", length = 512)
    private String responseDescription;

    @Column(name = "imageUrl")
    private String imageUrl;

    public MerchantResponse() {

    }
}
