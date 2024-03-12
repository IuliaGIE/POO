package org.example;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Admin<T extends Comparable<T>> extends Staff<T> {

    public Admin(@JsonProperty("information") Information userInfo,
                 @JsonProperty("userType") AccountType accountType) {
        super(userInfo, accountType);}
}
