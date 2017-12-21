package com.xylem.dewatering.fst.entity.embeddable;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Anoop.ks on 19-12-2017
 */
@Embeddable
public class AccountAddress {

    @Column(name = "account_address_line_1")
    @ApiModelProperty(required = true, notes = "Street line address of the account")
    private String address_line_1;

    @Column(name = "account_address_line_2")
    @ApiModelProperty(required = true, notes = "Street line address of the account")
    private String address_line_2;

    @Column(name = "account_city")
    @ApiModelProperty(required = true, notes = "City where the account resides")
    private String city;

    @Column(name = "account_state")
    @ApiModelProperty(required = true, notes = "State where the account resides")
    private String state;

    @Column(name = "account_zip")
    @ApiModelProperty(required = true, notes = "Zip number where the account resides")
    private String zip;

    @Column(name = "account_country")
    @ApiModelProperty(required = true, notes = "Country where the account resides")
    private String country;

    public AccountAddress() {
    }

    public AccountAddress(String address_line_1, String address_line_2, String city,
                          String state, String zip, String country) {
        this.address_line_1 = address_line_1;
        this.address_line_2 = address_line_2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public String getAddress_line_1() {
        return address_line_1;
    }

    public String getAddress_line_2() {
        return address_line_2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "AccountAddress{" +
                "address_line_1='" + address_line_1 + '\'' +
                ", address_line_2='" + address_line_2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
