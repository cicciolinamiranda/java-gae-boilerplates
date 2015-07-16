package com.cloudsherpas.poc.dto;

import java.util.Date;

import com.cloudsherpas.poc.domain.Customer;

public class CustomerDTO {

    private Long id;
    private String name;
    private String emailAddress;
    private Date dateCreated;

    public CustomerDTO() {
    }

    public CustomerDTO(Customer source) {
        this.name = source.getName();
        this.emailAddress = source.getEmailAddress();
        this.dateCreated = source.getDateCreated().toDate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
