package com.example.calculator.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;


import com.example.calculator.Calculator;
import com.example.calculator.Operation;

public class CalculatorPresenter  {



    private final CalculatorView view;
    private final Calculator calculator;

    private boolean isDotPressed;
    private Operation previousOperation;

    private int divider;

    private static final int base = 10;
    private Double numOne = 0.0;
    private Double numTwo = null;



    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void onNumberPressed(int number) {
        if (numTwo == null) {
            if (isDotPressed) {
                numOne = numOne + number / (double) divider;
                divider *= base;
            } else {
                numOne = numOne * base + number;
            }
            showResult(numOne);
        } else {
            if (isDotPressed) {
                numTwo = numTwo + number / (double) divider;
                divider *= base;
            } else {
                numTwo = numTwo * base + number;
            }
            showResult(numTwo);
        }
    }

    public void onOperationPressed(Operation operation) {
        if (previousOperation != null) {
            double result = calculator.doOperation(numOne, numTwo, previousOperation);

            showResult(result);
            view.showResult(String.valueOf(result));

            numOne = result;

        }
        previousOperation = operation;

        numTwo = 0.0;

        isDotPressed = false;
    }

    private void showResult(double num) {
        long longValue = (long) num;

        if (longValue == num) {
            view.showResult(String.valueOf(longValue));
        } else {
            view.showResult(String.valueOf(num));
        }
    }

    public void onDotPressed() {
        if (!isDotPressed) {
            isDotPressed = true;
            divider = base;
        }
    }


}
