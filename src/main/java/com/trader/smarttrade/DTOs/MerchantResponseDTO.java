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
import javax.validation.constraints.NotEmpty;
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

    @NotEmpty(message = "A price must be stated")
    private Double responsePrice;

    @NotEmpty(message = "A description must be given")
    private String responseDescription;

    @NotEmpty(message = "A sample image needs to be uploded")
    private String imageUrl;
}
