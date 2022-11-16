package com.trader.smarttrade.Entities;

import com.trader.smarttrade.Enums.Category;
import com.trader.smarttrade.Utils.IdGenerator;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


//@ToString(exclude = "imageUrl")
@Getter
@Setter
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "user_request")
public class UserRequest {
        @Id
        @Column(name = "request_id", nullable = false)
        private String requestId;

        @Column(name = "title", length = 50)
        private String title;

        @CreationTimestamp()
        @Column(name="request_date")
        private Date requestDate;

        @ManyToOne()
        @JoinColumn(name = "user_id", referencedColumnName = "user_id")
        private Users user;

        @Column(name="max_price", nullable = false)
        private Double requestMaxPrice;

        @Column(name="min_price",nullable = false)
        private Double requestMinPrice;

        @Lob
        @Column(name="image_url",nullable = true)
        private byte[] imageUrl;

        @Transient
        private MultipartFile imageUrlPart;
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

        @Override
        public String toString() {
                return "UserRequest{" +
                        "requestId='" + requestId + '\'' +
                        ", title='" + title + '\'' +
                        ", requestDate=" + requestDate +
                        ", user=" + user +
                        ", requestMaxPrice=" + requestMaxPrice +
                        ", requestMinPrice=" + requestMinPrice +
                        ", imageUrl='" + imageUrl + '\'' +
                        ", category=" + category +
                        ", description='" + description + '\'' +
                        ", responses=" + responses +
                        '}';
        }
}
