package com.example.skalculator.model;

public class Inverse extends UnaryOperation{
    @Override
    double getUnaryOperationResult(double currentOperand) {
        return 1/currentOperand;
    }

    @Override
    public String setText(String currentValue) {
        if (currentValue.startsWith("-")) return "1/(" + currentValue + ")";
        return "1/"+currentValue;
    }
}
