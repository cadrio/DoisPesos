package com.doispesos.ui_activity;

import static com.doispesos.ui_activity.ConstantesActivities.MASSA;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doispesos.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;

public class Activity_EntradaDados extends AppCompatActivity {

    private Spinner spinner1;
    private Spinner spinner2;
    private EditText campo_valor1;
    private EditText campo_quantidade1;
    private EditText campo_valor2;
    private EditText campo_quantidade2;
    private FloatingActionButton fabCalcular;
    private HashMap<String, Double> mapa;
    private Calculadora calculoAtual = new Calculadora();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        setContentView(R.layout.entradadados_layout);
        setTitle("Produtos");

        Intent dataIn = getIntent();
        String chaveEnviada = (String) dataIn.getSerializableExtra("unidade");
        configuraSpinners(chaveEnviada);
        inicializaVariaveis();
        calculoAtual.configuraMapaConversao();

        fabCalcular = findViewById(R.id.fab_calcular);
        fabCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (campo_quantidade1.getText().toString().equals("") | campo_quantidade2.getText().toString().equals("") |
                        campo_valor1.getText().toString().equals("") | campo_valor2.getText().toString().equals("")) {
                    Toast.makeText(Activity_EntradaDados.this, "Por favor preencha todos os campos!", Toast.LENGTH_LONG).show();

                } else {

                    if (campo_quantidade1.getText().toString().equals("0") | campo_quantidade2.getText().toString().equals("0") |
                            campo_valor1.getText().toString().equals("0") | campo_valor2.getText().toString().equals("0")) {
                        Toast.makeText(Activity_EntradaDados.this, "Por favor preencha com valores diferentes de 0!", Toast.LENGTH_LONG).show();
                    } else {

                        Double valor1 = Double.parseDouble(campo_valor1.getText().toString());
                        Double quantidade1 = Double.parseDouble(campo_quantidade1.getText().toString());
                        Double valor2 = Double.parseDouble(campo_valor2.getText().toString());
                        Double quantidade2 = Double.parseDouble(campo_quantidade2.getText().toString());
                        String unidade1 = spinner1.getSelectedItem().toString();
                        String unidade2 = spinner2.getSelectedItem().toString();

                        calculoAtual.calculaBeneficio(valor1, quantidade1, unidade1, valor2, quantidade2, unidade2);
                        calculoAtual.emiteRelatorio(Activity_EntradaDados.this);
                    }
                }
            };
        });
        super.onCreate(savedInstanceState);
    }


    private void inicializaVariaveis() {


        campo_valor1 = findViewById(R.id.editText_valorp1);
        campo_quantidade1 = findViewById(R.id.editText_quantidadep1);

        campo_valor2 = findViewById(R.id.editText_valorp2);
        campo_quantidade2 = findViewById(R.id.editText_quantidadep2);

    }

    private void configuraSpinners(String chave) {

        if (chave.equals(MASSA)) {

            spinner1 = findViewById(R.id.spin_unidade1);
            spinner1.setAdapter(ArrayAdapter.createFromResource(this, R.array.listaMassica, R.layout.support_simple_spinner_dropdown_item));

            spinner2 = findViewById(R.id.spin_unidade2);
            spinner2.setAdapter(ArrayAdapter.createFromResource(this, R.array.listaMassica, R.layout.support_simple_spinner_dropdown_item));
        } else {

            spinner1 = findViewById(R.id.spin_unidade1);
            spinner1.setAdapter(ArrayAdapter.createFromResource(this, R.array.listaVolumetrica, R.layout.support_simple_spinner_dropdown_item));

            spinner2 = findViewById(R.id.spin_unidade2);
            spinner2.setAdapter(ArrayAdapter.createFromResource(this, R.array.listaVolumetrica, R.layout.support_simple_spinner_dropdown_item));
        }


    }

}
