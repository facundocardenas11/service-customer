package com.customer.servicecustomers.dtos;

public class CustomerAverageDTO {

    private int average;

    public CustomerAverageDTO(int average){
        this.average = average;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }
}
