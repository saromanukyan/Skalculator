package com.example.skalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.skalculator.model.Calculator;
import com.example.skalculator.model.Number;
import com.example.skalculator.model.Special;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textViewSecondary;
    TextView textViewPrimary;
    String preservedOperator = "btnEqual";
    double preservedValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPrimary = findViewById(R.id.textViewPrimary);
        textViewSecondary = findViewById(R.id.textViewSecondary);
        TextView buttonSquare = findViewById(R.id.btnSquare);
        TextView buttonCube = findViewById(R.id.btnCube);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            buttonSquare.setText(Html.fromHtml("x<sup><small>2</small></sup"));
            buttonCube.setText(Html.fromHtml("x<sup><small>3</small></sup"));
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            getMenuInflater().inflate(R.menu.menu_normal_to_scientific, menu);
        } else getMenuInflater().inflate(R.menu.menu_scientific_to_normal, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.scientific) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            return true;
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("primary", textViewPrimary.getText().toString());
        outState.putString("secondary", textViewSecondary.getText().toString());
        outState.putString("operator", preservedOperator);
        outState.putDouble("value", preservedValue);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textViewSecondary.setText(savedInstanceState.getString("secondary"));
        textViewPrimary.setText(savedInstanceState.getString("primary"));
        preservedOperator = savedInstanceState.getString("operator");
        preservedValue = savedInstanceState.getDouble("value");
    }

    private double textToDouble(String text) {
        String result = text.replaceAll("[^-0-9.E]", "");
        if (result.equals("-") || result.length() == 0) return 0;
        double d = Double.parseDouble(result);
        return d + 0;
    }

    private void setAllToDefault() {
        textViewPrimary.setText("");
        textViewSecondary.setText("");
        preservedValue = 0;
        preservedOperator = "btnEqual";
    }

    @Override
    public void onClick(View v) {
        String pressedBtnText = String.valueOf(((TextView) v).getText());
        String pressedBtnName = v.getResources().getResourceEntryName(v.getId());
        String pressedBtnTag = v.getTag().toString();
        String currentTextView = String.valueOf(textViewPrimary.getText());
        double currentValue = textToDouble(currentTextView);

        switch (pressedBtnTag) {
            case "NUMBER":
                textViewPrimary.setText(new Number(pressedBtnText, currentTextView).showText());
                break;
            case "BINARY":
                if (currentTextView.contains("impossible")) {

                    preservedValue = 0;
                    Calculator calc = new Calculator(preservedValue, preservedOperator);
                    textViewSecondary.setText(calc.showText());
                    textViewPrimary.setText("");

                }
                if (currentTextView.equals("")) {
                    preservedOperator = pressedBtnName;
                    currentValue = preservedValue;
                    Calculator calc = new Calculator(currentValue, preservedOperator);
                    textViewSecondary.setText(calc.showText());
                } else {
                    Calculator calc1 = new Calculator(preservedValue, currentValue, preservedOperator);
                    String result = calc1.result();
                    if (result.equals("impossible")) {
                        preservedValue = 0;
                        preservedOperator = "btnEqual";
                        textViewSecondary.setText(String.format("%s%s", textViewSecondary.getText(), " " + new
                                Calculator(currentValue, preservedOperator).result()));
                        textViewPrimary.setText(R.string.impossible);
                    } else {
                        preservedValue = textToDouble(calc1.result());
                        Calculator calc2 = new Calculator(preservedValue, pressedBtnName);
                        preservedOperator = pressedBtnName;
                        textViewSecondary.setText(calc2.showText());
                        textViewPrimary.setText("");

                    }
                }
                break;
            case "UNARY":
                if (currentTextView.contains("impossible")) {
                    preservedValue = 0;
                    preservedOperator = "btnEqual";
                    textViewSecondary.setText("");
                    textViewPrimary.setText("");
                }
                //  Calculator calcCurrent = new Calculator(currentValue, pressedBtnName);
                Calculator calcCurrent = new Calculator(preservedValue, currentValue, pressedBtnName);
                if (preservedOperator.equals("btnEqual")) {
                    textViewSecondary.setText(calcCurrent.showText());

                } else {
                    textViewSecondary.setText(String.format("%s%s", textViewSecondary.getText(), " " + calcCurrent.showText()));
                }
                String result = calcCurrent.result();
                if (result.equals("impossible")) {
                    preservedValue = 0;
                    preservedOperator = "btnEqual";
                    textViewPrimary.setText(R.string.impossible);
                } else {
                    currentValue = textToDouble(result);
                    Calculator calc = new Calculator(preservedValue, currentValue, preservedOperator);
                    textViewPrimary.setText(String.format("= %s", calc.result()));
                    preservedValue = textToDouble(calc.result());
                    preservedOperator = "btnEqual";
                }
                break;
            case "SPECIAL":
                String specialBtn = Special.valueOf(pressedBtnName.toUpperCase()).setText(currentTextView);
                if (specialBtn.equals("RESET")) {
                    setAllToDefault();

                } else textViewPrimary.setText(specialBtn);
                break;
        }
    }
}