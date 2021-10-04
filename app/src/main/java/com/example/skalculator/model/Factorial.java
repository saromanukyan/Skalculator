package com.example.skalculator.model;

public class Factorial extends UnaryOperation {
    @Override
    double getUnaryOperationResult(double currentOperand) {
        if (currentOperand>16)return Double.NaN;

        long fact = 1;
        for (int i = 2; i <= currentOperand; i++) {
            fact = fact * i;
        }
        return fact;

    }

    @Override
    public String setText(String currentValue) {
        return "(" + currentValue + ")!";
    }
}
