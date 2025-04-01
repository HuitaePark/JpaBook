package com.baki.jpaproject.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    public Address(String 서울, String 강가, String number) {
    }

    public Address() {

    }
}
