package com.pluralsight;

public class SemiTruck extends Vehicle {
        private int numberOfTrailers;

    public int getNumberOfTrailers() {
        return numberOfTrailers;
    }

    public void setNumberOfTrailers(int numberOfTrailers) {
        this.numberOfTrailers = numberOfTrailers;
    }

    public void loadCargo() {
            System.out.println("Cargo loaded.");
        }

        public void unloadCargo() {
            System.out.println("Cargo unloaded.");
        }
}
