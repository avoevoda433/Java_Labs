package com.drugstore;
import java.io.Serializable;

public class Drugstore implements Serializable {
    private String ownerSurname;
    private boolean hasLicense;
    private double monthlyProfit;

    public Drugstore(String ownerSurname, boolean hasLicense, double monthlyProfit) {
        this.ownerSurname = ownerSurname;
        this.hasLicense = hasLicense;
        this.monthlyProfit = monthlyProfit;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public boolean hasLicense() {
        return hasLicense;
    }

    public double getMonthlyProfit() {
        return monthlyProfit;
    }

    @Override
    public String toString() {
        return "Drugstore{" +
                "ownerSurname='" + ownerSurname + '\'' +
                ", hasLicense=" + hasLicense +
                ", monthlyProfit=" + monthlyProfit +
                '}';
    }
}
