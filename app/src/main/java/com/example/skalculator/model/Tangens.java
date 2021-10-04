package com.example.skalculator.model;

public class Tangens extends UnaryOperation {
    @Override
    double getUnaryOperationResult(double currentOperand) {
        return Math.tan(Math.toRadians(currentOperand));
    }

    @Override
    public String setText(String currentValue) {
        return "tan(" + currentValue + ")";
    }
}
