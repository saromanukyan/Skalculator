package com.example.skalculator.model;

public class Sine extends UnaryOperation {
    @Override
    double getUnaryOperationResult(double currentOperand) {
        return Math.sin(Math.toRadians(currentOperand));
    }

    @Override
    public String setText(String currentValue) {
        return "sin(" + currentValue + ")";
    }
}
