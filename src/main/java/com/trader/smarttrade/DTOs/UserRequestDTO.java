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
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    private String requestId;

    @NotEmpty(message = "The title cannot be empty")
    private String title;

    private Users user;

    @NotEmpty(message = "Price range is required")
    private Double requestMaxPrice;

    @NotEmpty(message = "Price range is required")
    private Double requestMinPrice;

    @NotEmpty(message = "A sample image should be uplaoded")
    private String imageUrl;

    private Category category;
    @NotEmpty(message = "A description needs to be given")
    private String description;

    private Date requestDate;

}
