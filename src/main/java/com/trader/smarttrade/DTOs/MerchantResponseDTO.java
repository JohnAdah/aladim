package com.trader.smarttrade.DTOs;

import com.trader.smarttrade.Entities.UserRequest;
import com.trader.smarttrade.Entities.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MerchantResponseDTO {
    private String responseId;

    private Users user;

    private UserRequest request;

    @DateTimeFormat(pattern = "dd-mm-yy HH:MM")
    private Date responseDate;

    @DateTimeFormat(pattern = "dd-mm-yy HH:MM")
    private Date updatedDate;

    @NotEmpty(message = "A price must be stated")
    private Double responsePrice;

    @NotEmpty(message = "A description must be given")
    private String responseDescription;

    @NotEmpty(message = "A sample image needs to be uploaded")
    private String imageUrl;
}
