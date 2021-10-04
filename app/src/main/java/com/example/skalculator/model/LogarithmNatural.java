package com.example.skalculator.model;

public class LogarithmNatural extends UnaryOperation {
    @Override
    double getUnaryOperationResult(double currentOperand) {
        return Math.log(currentOperand);
    }

    @Override
    public String setText(String currentValue) {
        return "ln(" + currentValue + ")";
    }
}
