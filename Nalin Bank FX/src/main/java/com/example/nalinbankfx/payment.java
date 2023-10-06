package com.example.nalinbankfx;

public class payment {
    String name;
    Double sum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public payment(String name, Double sum) {
        this.name = name;
        this.sum = sum;
    }
}
