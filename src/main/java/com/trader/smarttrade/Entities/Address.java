package com.trader.smarttrade.Entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter

@Embeddable
public class Address {
    @Column(name = "address_line1", nullable = false)
    private String addressLine1;
    @Column(name = "address_line2", nullable = false)
    private String addressLine2;
    @Column(name = "local_gov_area",  nullable = false)
    private String localGovArea;

    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "state_of_city", nullable = false)
    private String stateOfCity;
    @Column(name = "postal_code",  nullable = true)
    private int postalCode;
    @Column(name = "country",  nullable = false)
    private String country;
}
