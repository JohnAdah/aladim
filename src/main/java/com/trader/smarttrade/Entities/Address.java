package com.trader.smarttrade.Entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Data

@Embeddable
public class Address {
    @Column(name = "address_line1", length = 50, nullable = false)
    private String addressLine1;
    @Column(name = "address_line2", length = 50, nullable = false)
    private String addressLine2;
    @Column(name = "local_gov_area", length = 20, nullable = false)
    private String localGovArea;
    @Column(name = "city", length = 20, nullable = false)
    private String city;
    @Column(name = "state_of_city", length = 20, nullable = false)
    private String stateOfCity;
    @Column(name = "postal_code", length = 20, nullable = true)
    private int postalCode;
    @Column(name = "country", length = 20, nullable = false)
    private String country;
}
