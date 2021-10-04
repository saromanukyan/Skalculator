package com.example.skalculator.model;

public class IntegerPart extends UnaryOperation {
    @Override
    double getUnaryOperationResult(double currentOperand) {
        return (int) currentOperand;
    }

    @Override
    public String setText(String currentValue) {
        return "int(" + currentValue + ")";
    }
}
