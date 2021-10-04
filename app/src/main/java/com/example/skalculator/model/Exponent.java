package com.example.skalculator.model;

public class Exponent extends UnaryOperation {
    @Override
    double getUnaryOperationResult(double currentOperand) {
        return Math.E;
    }

    @Override
    public String setText(String currentValue) {
        return "e";
    }
}
