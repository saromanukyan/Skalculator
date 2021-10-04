package com.example.skalculator.model;

public class Percent extends BinaryOperation {

    @Override
    public String setText(String currentValue) {
        return "(" + currentValue + ")%";
    }

    @Override
    double getBinaryOperationResult(double preservedOperand, double currentOperand) {
        return preservedOperand/100*currentOperand;
    }
}
