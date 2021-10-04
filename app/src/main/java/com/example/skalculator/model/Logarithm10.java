package com.example.skalculator.model;

public class Logarithm10 extends UnaryOperation {
    @Override
    double getUnaryOperationResult(double currentOperand) {
        return Math.log10(currentOperand);
    }

    @Override
    public String setText(String currentValue) {
        return "lg(" + currentValue + ")";
    }
}
