package com.pluralsight.finance;

public class Jewelry extends FixedAsset {
    private double karat;


    public Jewelry(String name, double karat) {
        super(name, calculateValue(karat));
        this.karat = karat;
    }

    public double getKarat() {
        return karat;
    }

    private static double calculateValue(double karat) {
        // Simple calculation: higher karat = higher value
        return karat * 1000;
    }

    
    @Override
    public double getValue() {
        // Could implement specific valuation logic here
        return marketValue;
    }
}
