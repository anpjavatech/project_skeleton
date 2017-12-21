package com.xylem.dewatering.fst.entity;

import com.xylem.dewatering.fst.entity.embeddable.AccountAddress;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

/**
 * Created by Anoop.ks on 19-12-2017
 */

@Entity
@Table(name = "customer_accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private int id;

    @Column(name = "account_name")
    @ApiModelProperty(required = true, notes = "Name of the Account that customer holds.")
    private String name;

    @Column(name = "account_phone_number")
    @ApiModelProperty(required = true, notes = "Phone Number of the Account that customer holds.")
    private String phoneNumber;

    @Column(name = "account_status")
    @ApiModelProperty(required = true, notes = "Status of the Account that customer holds.")
    private String status;

    @Column(name = "account_email")
    @ApiModelProperty(required = true, notes = "Email of the Account that customer holds.")
    private String email;

    @Column(name = "account_location")
    @ApiModelProperty(required = true, notes = "Location of the Account that customer holds.")
    private String location;

    @Column(name = "account_customer_id")
    @ApiModelProperty(required = true, notes = "Customer ID for which the Account related to.")
    private String customer_id;

    @Embedded
    private AccountAddress address;

    public Account(String name, String phoneNumber, String status, String email,
                   String location, String customer_id, AccountAddress address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.email = email;
        this.location = location;
        this.customer_id = customer_id;
        this.address = address;
    }

    public int getId() {
        return id;
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

    public AccountAddress getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return id == account.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status='" + status + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", customer_id='" + customer_id + '\'' +
                ", address=" + address +
                '}';
    }
}
