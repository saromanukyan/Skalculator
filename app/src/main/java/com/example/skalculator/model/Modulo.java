package com.example.skalculator.model;

public class Modulo extends BinaryOperation {
    @Override
    double getBinaryOperationResult(double preservedOperand, double currentOperand) {
        return preservedOperand % currentOperand;
    }

    @Override
    public String setText(String currentValue) {
        if (currentValue.startsWith("-")) return "(" + currentValue + ") mod";
        return currentValue + " mod";
    }
}
