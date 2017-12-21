package com.xylem.dewatering.fst.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by Anoop.ks on 19-12-2017
 */
public class AccountDto {

    @JsonProperty(required = true)
    @NotNull
    private String name;

    @JsonProperty(required = true)
    @NotNull
    private String phoneNumber;

    @JsonProperty(required = true)
    @NotNull
    private String status;

    @JsonProperty(required = true)
    @NotNull
    private String email;

    @JsonProperty(required = true)
    @NotNull
    private String location;

    @JsonProperty(required = true)
    @NotNull
    private String customer_id;

    @JsonProperty(required = true)
    @NotNull
    private String address_line_1;

    @JsonProperty(required = true)
    @NotNull
    private String address_line_2;

    @JsonProperty(required = true)
    @NotNull
    private String city;

    @JsonProperty(required = true)
    @NotNull
    private String state;

    @JsonProperty(required = true)
    @NotNull
    private String zip;

    @JsonProperty(required = true)
    @NotNull
    private String country;


    public AccountDto(@JsonProperty("name")String name,@JsonProperty("phoneNumber") String phoneNumber,
                      @JsonProperty("status") String status,@JsonProperty("email") String email,
                      @JsonProperty("location")String location,@JsonProperty("customer_id") String customer_id,
                      @JsonProperty("address_line_1")String address_line_1, @JsonProperty("address_line_2")String address_line_2,
                      @JsonProperty("city") String city, @JsonProperty("state")String state,
                      @JsonProperty("zip") String zip, @JsonProperty("country")String country) {

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.email = email;
        this.location = location;
        this.customer_id = customer_id;
        this.address_line_1 = address_line_1;
        this.address_line_2 = address_line_2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public String getCustomer_id() {
        return customer_id;
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
        return "AccountDto{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status='" + status + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", customer_id='" + customer_id + '\'' +
                ", address_line_1='" + address_line_1 + '\'' +
                ", address_line_2='" + address_line_2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
