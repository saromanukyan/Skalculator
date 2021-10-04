package com.example.skalculator.model;

public class Cube extends UnaryOperation {
    @Override
    double getUnaryOperationResult(double currentOperand) {
        return Math.pow(currentOperand,3);
    }

    @Override
    public String setText(String currentValue) {
        return "(" + currentValue + ")^3";
    }
}
