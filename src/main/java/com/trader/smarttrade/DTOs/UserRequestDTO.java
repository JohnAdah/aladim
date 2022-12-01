package com.trader.smarttrade.DTOs;

import com.trader.smarttrade.Entities.Users;
import com.trader.smarttrade.Enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    private String requestId;

    @NotEmpty(message = "The title cannot be empty")
    private String title;

    private Users user;

    @NotNull(message = "Price range is required")
    private Double requestMaxPrice;

    @NotNull(message = "Price range is required")
    private Double requestMinPrice;

    private String imageUrl;

    private Category category;
    @NotEmpty(message = "A description needs to be given")
    private String description;

    @DateTimeFormat(pattern = "dd-mm-yy HH:MM")
    private Date requestDate;

    @DateTimeFormat(pattern = "dd-mm-yy HH:MM")
    private Date updatedDate;

}
