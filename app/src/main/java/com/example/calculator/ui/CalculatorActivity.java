package com.example.calculator.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.CalculatorImp;
import com.example.calculator.Operation;
import com.example.calculator.R;

import java.util.HashMap;
import java.util.Map;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView {

    private TextView txtResult;

    private CalculatorPresenter presenter;


    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calculator);

        presenter = new CalculatorPresenter(this, new CalculatorImp());

        txtResult = findViewById(R.id.txt_result);

        Map<Integer, Integer> numbers = new HashMap<>();
        numbers.put(R.id.but_0, 0);
        numbers.put(R.id.but_1, 1);
        numbers.put(R.id.but_2, 2);
        numbers.put(R.id.but_3, 3);
        numbers.put(R.id.but_4, 4);
        numbers.put(R.id.but_5, 5);
        numbers.put(R.id.but_6, 6);
        numbers.put(R.id.but_7, 7);
        numbers.put(R.id.but_8, 8);
        numbers.put(R.id.but_9, 9);

        View.OnClickListener numbersClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onNumberPressed(numbers.get(v.getId()));
            }
        };

        findViewById(R.id.but_0).setOnClickListener(numbersClickListener);
        findViewById(R.id.but_1).setOnClickListener(numbersClickListener);
        findViewById(R.id.but_2).setOnClickListener(numbersClickListener);
        findViewById(R.id.but_3).setOnClickListener(numbersClickListener);
        findViewById(R.id.but_4).setOnClickListener(numbersClickListener);
        findViewById(R.id.but_5).setOnClickListener(numbersClickListener);
        findViewById(R.id.but_6).setOnClickListener(numbersClickListener);
        findViewById(R.id.but_7).setOnClickListener(numbersClickListener);
        findViewById(R.id.but_8).setOnClickListener(numbersClickListener);
        findViewById(R.id.but_9).setOnClickListener(numbersClickListener);

        Map<Integer, Operation> operators = new HashMap<>();
        operators.put(R.id.but_sum, Operation.SUM);
        operators.put(R.id.but_sub, Operation.SUB);
        operators.put(R.id.but_mult, Operation.MULT);
        operators.put(R.id.but_div, Operation.DIV);


        View.OnClickListener operationClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onOperationPressed(operators.get(v.getId()));
            }
        };

        findViewById(R.id.but_sum).setOnClickListener(operationClickListener);
        findViewById(R.id.but_sub).setOnClickListener(operationClickListener);
        findViewById(R.id.but_mult).setOnClickListener(operationClickListener);
        findViewById(R.id.but_div).setOnClickListener(operationClickListener);

        findViewById(R.id.but_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDotPressed();
            }
        });

        Button butLog = findViewById(R.id.but_log);
        Button butDeg = findViewById(R.id.but_deg);
        Button butSrt= findViewById(R.id.but_sqr);
        Button butPer = findViewById(R.id.but_per);

        if (butLog != null) {
            findViewById(R.id.but_log).setOnClickListener(operationClickListener);
        }
        if (butDeg != null) {
            findViewById(R.id.but_log).setOnClickListener(operationClickListener);
        }
        if (butSrt != null) {
            findViewById(R.id.but_log).setOnClickListener(operationClickListener);
        }
        if (butPer != null) {
            findViewById(R.id.but_log).setOnClickListener(operationClickListener);
        }
    }


    @Override
    public void showResult(String result) {
        txtResult.setText(result);

    }
}
