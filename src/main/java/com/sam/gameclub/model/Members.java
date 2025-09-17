package com.sam.gameclub.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "members")
public class Members {
    @Id
    private String id;
    private String name;
    private String phone_number;
    private float balance;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public float getBalance() {
        return balance;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Members(String id, String name, String phone_number, float balance) {
        this.id = id;
        this.name = name;
        this.phone_number = phone_number;
        this.balance = balance;
    }

    public Members() {
    }

    @Override
    public String toString() {
        return "Members [id=" + id + ", name=" + name + ", phone_number=" + phone_number + ", balance=" + balance + "]";
    }
}
