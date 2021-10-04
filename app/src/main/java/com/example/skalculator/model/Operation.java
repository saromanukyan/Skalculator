package com.example.skalculator.model;

public abstract class Operation implements DisplayText {
    private double preservedOperand;
    private double currentOperand;

    public double getPreservedOperand() {
        return preservedOperand;
    }

    public void setPreservedOperand(double preservedOperand) {
        this.preservedOperand = preservedOperand;
    }

    public double getCurrentOperand() {
        return currentOperand;
    }

    public void setCurrentOperand(double currentOperand) {
        this.currentOperand = currentOperand;
    }

    abstract double execute();
}
