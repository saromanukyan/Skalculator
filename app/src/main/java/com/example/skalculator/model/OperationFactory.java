package com.example.skalculator.model;

import java.util.HashMap;
import java.util.Map;

public class OperationFactory {
    private static final Map<String, Operation> operationMap = new HashMap<>();

    static {
        operationMap.put("btnEqual", new Equal());
        operationMap.put("btnAddition", new Addition());
        operationMap.put("btnSubtraction", new Subtraction());
        operationMap.put("btnMultiplication", new Multiplication());
        operationMap.put("btnDivision", new Division());

        operationMap.put("btnSine", new Sine());
        operationMap.put("btnCosine", new Cosine());
        operationMap.put("btnTangens", new Tangens());
        operationMap.put("btnSquareRoot", new SquareRoot());
        operationMap.put("btnLn", new LogarithmNatural());
        operationMap.put("btnLog", new Logarithm10());
        operationMap.put("btnInt", new IntegerPart());
        operationMap.put("btnModulo", new Modulo());
        operationMap.put("btnPi", new Pi());
        operationMap.put("btnExp", new Exponent());
        operationMap.put("btnInverse", new Inverse());
        operationMap.put("btnSquare", new Square());
        operationMap.put("btnCube", new Cube());
        operationMap.put("btnFactorial", new Factorial());
        operationMap.put("btnPercent", new Percent());
    }

    public static Operation getOperation(String operation) {
        return operationMap.get(operation);
    }
}
