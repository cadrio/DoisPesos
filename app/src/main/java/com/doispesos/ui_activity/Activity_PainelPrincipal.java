package com.doispesos.ui_activity;

import static com.doispesos.ui_activity.ConstantesActivities.MASSA;
import static com.doispesos.ui_activity.ConstantesActivities.VOLUME;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.doispesos.R;


public class Activity_PainelPrincipal extends Activity {



    Button botaoMassa;
    Button botaoVolume;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        setContentView(R.layout.painelprincipal_layout);
        configuraBotoes();
        super.onCreate(savedInstanceState);
    }


    private void configuraBotoes() {
        botaoMassa = findViewById(R.id.painelprincipal_botaoMassa);
        botaoMassa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreFormularioConversao(MASSA);
            }
        });

        botaoVolume = findViewById(R.id.painelprincipal_botaoVolume);
        botaoVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreFormularioConversao(VOLUME);
            }
        });
    }

    private void abreFormularioConversao(String MassaOuVolume) {

        Intent intentConversao = new Intent(Activity_PainelPrincipal.this, Activity_EntradaDados.class);
        intentConversao.putExtra("unidade",MassaOuVolume);
        startActivity(intentConversao);


    }
}






