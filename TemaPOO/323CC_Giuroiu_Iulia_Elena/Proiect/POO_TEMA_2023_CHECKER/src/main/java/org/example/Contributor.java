package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Contributor<T extends Comparable<T>> extends Staff<T> implements RequestsManager {


    @JsonCreator
    public Contributor(@JsonProperty("information") Information userInfo,
                       @JsonProperty("userType") AccountType accountType) {
        super(userInfo, accountType);
    }
    @Override
    public void createRequest(Request r) {
        RequestsHolder.addRequest(r);
    }

    @Override
    public void removeRequest(Request r) {
        RequestsHolder.removeRequest(r);
    }

}
