package com.trader.smarttrade.Entities;

import com.trader.smarttrade.Enums.MerchantCategory;
import com.trader.smarttrade.Utils.IdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@Data
@Entity
@Table(name = "user_request")
public class UserRequest {
        @Id
        @Column(name = "request_id", nullable = false)
        private String requestId;

        @Column(name = "merchant_category",nullable = false)
        @Enumerated(EnumType.STRING)
        private MerchantCategory requestCategory;

        @CreationTimestamp()
        @Temporal(TemporalType.TIMESTAMP)
        @Column(name="request_date")
        private Date requestDate;

        @ManyToOne()
        @JoinColumn(name = "user_id", referencedColumnName = "user_id")
        private Users user_id;

        @Column(name="max_price", nullable = false)
        private Double requestMaxPrice;

        @Column(name="min_price",nullable = false)
        private Double requestMinPrice;

        @Column(name="image_url",nullable = true)
        private String imageUrl;

        @OneToMany(mappedBy = "request_Id", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
        List<MerchantResponse> responses;


        public UserRequest() {
                String prefix = "RQ";
                this.requestId = IdGenerator.customIdGenerator(prefix,200,300);
        }



}
