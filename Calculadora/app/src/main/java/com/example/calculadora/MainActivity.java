package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btnMais,btnMenos,btnVezes,btnDivisao;
    ImageButton reiniciaBtn;
    TextView result;
     EditText num1Text, num2Text;
    MainActivity a = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMais = findViewById(R.id.btnMais);
        btnMenos = findViewById(R.id.btnMenos);
        btnVezes = findViewById(R.id.btnVezes);
        btnDivisao = findViewById(R.id.btnDivisao);
        result = findViewById(R.id.textResult);
        num1Text = findViewById(R.id.num1Text);
        num2Text = findViewById(R.id.num2Text);
        reiniciaBtn = findViewById(R.id.imageButton);

        btnMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float resultado = Float.parseFloat(num1Text.getText().toString()) + Float.parseFloat(num2Text.getText().toString());
                result.setText(resultado.toString());
                hideSoftKeyboard(a);
            }
        });
        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float resultado = Float.parseFloat(num1Text.getText().toString()) - Float.parseFloat(num2Text.getText().toString());
                result.setText(resultado.toString());
                hideSoftKeyboard(a);
            }
        });
        btnVezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float resultado = Float.parseFloat(num1Text.getText().toString()) * Float.parseFloat(num2Text.getText().toString());
                result.setText(resultado.toString());
            }
        });
        btnDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float resultado = Float.parseFloat(num1Text.getText().toString()) / Float.parseFloat(num2Text.getText().toString());
                result.setText(resultado.toString());
            }
        });
        reiniciaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1Text.setText("");
                num2Text.setText("");
                result.setText("");
                hideSoftKeyboard(a);
            }
        });
    }


    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }
}
