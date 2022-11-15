package com.trader.smarttrade.DTOs;

import com.trader.smarttrade.Entities.MerchantResponse;
import com.trader.smarttrade.Entities.Users;
import com.trader.smarttrade.Enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    private String requestId;

    private String title;

    private Users user;

    private Double requestMaxPrice;

    private Double requestMinPrice;

    private String imageUrl;

    private Category category;

    private String description;

    private Date requestDate;

}
