package com.doispesos.ui_activity;

import android.content.Context;
import android.widget.Toast;

import java.util.HashMap;

public class Calculadora {

    private HashMap<String, Double> mapaConversao = new HashMap<String, Double>();
    private Double valorUnitario1;
    private Double valorUnitario2;

    public HashMap<String, Double> getMapaConversao() {
        return mapaConversao;
    }

    public void configuraMapaConversao() {

        mapaConversao.put("miligramas", 0.001);
        mapaConversao.put("gramas", 1.0);
        mapaConversao.put("kilogramas", 1000.0);

        mapaConversao.put("mililitros", 1.0);
        mapaConversao.put("litros", 1000.0);

    }

    public void calculaBeneficio(Double valor1, Double quantidade1, String unidade1, Double valor2, Double quantidade2, String unidade2) {

        this.valorUnitario1 = valor1 / (quantidade1 * mapaConversao.get(unidade1));
        this.valorUnitario2 = valor2 / (quantidade2 * mapaConversao.get(unidade2));

    }


    public void emiteRelatorio(Context context) {




        if (this.valorUnitario1 > this.valorUnitario2) {

            Toast.makeText(context, "O produto B é "+((this.valorUnitario1-this.valorUnitario2)/this.valorUnitario1)*100+
                    "% mais barato.", Toast.LENGTH_SHORT).show();


        } else {
            if (this.valorUnitario1 < this.valorUnitario2) {

                Toast.makeText(context, "O produto A é "+((this.valorUnitario2-this.valorUnitario1)/this.valorUnitario2)*100+
                        "% mais barato.", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(context, "Os produtos possuem o mesmo custo benefício!", Toast.LENGTH_SHORT).show();
            }
        }


    }
}
