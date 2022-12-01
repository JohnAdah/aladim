package com.trader.smarttrade.Entities;

import com.trader.smarttrade.Enums.Category;
import com.trader.smarttrade.Utils.IdGenerator;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


//@ToString(exclude = "imageUrl")
@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_request")
public class UserRequest {
        @Id
        @Column(name = "request_id", nullable = false)
        private String requestId;

        @Column(name = "title")
        private String title;

        @UpdateTimestamp
        @Column(name = "updated_date")
        private Date updatedDate;


        @CreationTimestamp
        @Column(name="request_date")
        private Date requestDate;

        @ManyToOne()
        @JoinColumn(name = "user_id", referencedColumnName = "user_id")
        private Users user;

        @Column(name="max_price", nullable = false)
        private Double requestMaxPrice;

        @Column(name="min_price",nullable = false)
        private Double requestMinPrice;

        @Column(name="imageUrl",nullable = true)
        private String imageUrl;

        @Enumerated(EnumType.STRING)
        @Column(name = "Category")
        private Category category;

        @Column(name = "description", length = 512)
        private String description;

        @OneToMany(mappedBy = "request", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
        List<MerchantResponse> responses;


        public UserRequest() {
                String prefix = "RQ";
                this.requestId = IdGenerator.customIdGenerator(prefix,200,300);
        }

}
