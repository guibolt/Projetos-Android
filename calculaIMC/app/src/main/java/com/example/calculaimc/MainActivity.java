package com.example.calculaimc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    EditText nome,peso,altura;
    Button botao;
    ImageButton botaoReiniciar;
    TextView result;

    MainActivity l = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.textNome);
        peso = findViewById(R.id.textPeso);
        altura = findViewById(R.id.textAltura);
        botao = findViewById(R.id.btnS);
        botaoReiniciar = findViewById(R.id.botaoImagem);
        result = findViewById(R.id.textResultado);

        botao.setOnClickListener(new View.OnClickListener() {
            DecimalFormat df = new DecimalFormat("00.0");
            @Override
            public void onClick(View v) {
                Float imcDele = calculaImc(
                        Float.parseFloat(peso.getText().toString()),
                        Float.parseFloat(altura.getText().toString())
                );

                hideSoftKeyboard(l);

               result.setText("Olá " + nome.getText() + " seu imc é " + df.format(imcDele)+ " e sua situação é: " + retornaSitacao(imcDele));
            }
        });

        botaoReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              limparTextos(altura,peso,nome,result);
            }
        });

    }
    private void limparTextos(EditText textAltura, EditText textPeso, EditText textNome, TextView result){
        textAltura.setText("");
        textPeso.setText("");
        textNome.setText("");
        result.setText("");
    }

    private Float calculaImc(Float peso, Float alturaL){
        return peso / (alturaL * alturaL);
    }

    private String retornaSitacao(Float imc){

        if(imc < 18.5){
            return "abaixo do peso";
        } else if (imc >= 18.5 && imc <= 24.8){
            return "Peso normal";
        }
        else if (imc >= 25.0 && imc <= 29.9){
            return "Sobrepeso";
        }
        else if (imc >= 30.0 && imc <= 34.4){
            return "Obesidade grau 1";
        }
        else if (imc >= 35 && imc <= 39.9){
            return "Obesidade grau 2";
        }
        else {
            return "Obesidade grau 3";
        }
    }
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }
}
