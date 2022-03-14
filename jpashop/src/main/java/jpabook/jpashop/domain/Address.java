package jpabook.jpashop.domain;


import lombok.Getter;

import javax.persistence.Embeddable;


//값타입은 변경이 이루어지면 안된다. 따라서 setter가 존재하면 안된다.
@Embeddable
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    // 어느정도 보호를 위한
    protected Address(){
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
