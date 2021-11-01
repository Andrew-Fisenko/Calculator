package com.example.calculator;

public class CalculatorImp implements Calculator {

    @Override
    public double doOperation(double numOne, double numTwo, Operation operation) {
        switch (operation){
            case SUM:
                return numOne + numTwo;
            case SUB:
                return numOne - numTwo;
            case DIV:
                return numOne / numTwo;
            case MULT:
                return numOne * numTwo;
        }
        return 0.0;
    }
}
