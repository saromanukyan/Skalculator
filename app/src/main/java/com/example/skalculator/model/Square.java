package com.example.skalculator.model;

public class Square extends UnaryOperation {
    @Override
    double getUnaryOperationResult(double currentOperand) {
        return currentOperand*currentOperand;
    }

    @Override
    public String setText(String currentValue) {
        return "(" + currentValue + ")^2";
    }
}
