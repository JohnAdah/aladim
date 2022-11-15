package com.trader.smarttrade.DTOs;

import com.trader.smarttrade.Entities.UserRequest;
import com.trader.smarttrade.Entities.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MerchantResponseDTO {
    private String responseId;

    private Users user;

    private UserRequest request;

    private LocalDate responseDate;

    private Double responsePrice;

    private String responseDescription;

    private String imageUrl;
}
