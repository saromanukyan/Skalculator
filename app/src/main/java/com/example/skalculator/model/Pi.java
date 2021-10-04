package com.example.skalculator.model;

public class Pi extends UnaryOperation{
    @Override
    double getUnaryOperationResult(double currentOperand) {
        return Math.PI;
    }

    @Override
    public String setText(String currentValue) {
        return "π";
    }
}
