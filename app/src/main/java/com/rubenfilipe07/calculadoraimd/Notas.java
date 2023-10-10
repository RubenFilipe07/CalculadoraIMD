package com.rubenfilipe07.calculadoraimd;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Notas extends Fragment {

    private EditText input1;
    private EditText input2;
    private EditText input3;
    private TextView outputCondicao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notas, container, false);

        input1 = view.findViewById(R.id.input_nota1);
        input2 = view.findViewById(R.id.input_nota2);
        input3 = view.findViewById(R.id.input_nota3);
        outputCondicao = view.findViewById(R.id.output_notas);

        Button buttonCalcular = view.findViewById(R.id.btn_calcular_nota);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularNotas();
            }
        });

        return view;
    }

    public void calcularNotas() {
        double media = 0;
        int[] faltaUnidades = new int[2];

        try {
            double nota1 = Double.parseDouble(input1.getText().toString());
            double nota2 = Double.parseDouble(input2.getText().toString());
            double nota3 = Double.parseDouble(input3.getText().toString());

            if (nota1 > 10 || nota1 < 0) {
                input1.setError("Digite algo entre 0-10");
                return;
            }

            if (nota2 > 10 || nota2 < 0) {
                input2.setError("Digite algo entre 0-10");
                return;
            }

            if (nota3 > 10 || nota3 < 0) {
                input3.setError("Digite algo entre 0-10");
                return;
            }

            String condicao = "";

            media = (nota1 + nota2 + nota3) / 3;

            if (media >= 7) {
                condicao = "Aprovado";
                Toast.makeText(getActivity(), "Aprovado", Toast.LENGTH_SHORT).show();
            } else if (media >= 5 && media < 7) {
                condicao = "Aprovado por Nota";
                Toast.makeText(getActivity(), "Aprovado por Nota", Toast.LENGTH_SHORT).show();
            } else if (media < 5) {
                condicao = "Reprovado";
                Toast.makeText(getActivity(), "Reprovado", Toast.LENGTH_SHORT).show();
            }


            outputCondicao.setText("Situação: " + condicao);
        } catch (NumberFormatException e) {

            if (taVazio(input1) && taVazio(input2) && taVazio(input3)) {
                Toast.makeText(getActivity(), "Digite ao menos um valor válido", Toast.LENGTH_LONG).show();

            } else if (taVazio(input1) && taVazio(input2)) {
                double nota3 = Double.parseDouble(input3.getText().toString());
                faltaUnidades[0] = 2;
                faltaUnidades[1] = 3;
                calcularMediaUmValor(nota3, faltaUnidades);
            } else if (taVazio(input1) && taVazio(input3)) {
                double nota2 = Double.parseDouble(input2.getText().toString());
                faltaUnidades[0] = 1;
                faltaUnidades[1] = 3;
                calcularMediaUmValor(nota2, faltaUnidades);

            } else if (taVazio(input2) && taVazio(input3)) {
                double nota1 = Double.parseDouble(input1.getText().toString());
                faltaUnidades[0] = 2;
                faltaUnidades[1] = 3;
                calcularMediaUmValor(nota1, faltaUnidades);
            } else if (taVazio(input1)) {
                double nota2 = Double.parseDouble(input2.getText().toString());
                double nota3 = Double.parseDouble(input3.getText().toString());
                faltaUnidades[0] = 1;
                calcularMediaDoisValores(nota2, nota3, faltaUnidades);
            } else if (taVazio(input2)) {
                double nota1 = Double.parseDouble(input1.getText().toString());
                double nota3 = Double.parseDouble(input3.getText().toString());
                faltaUnidades[0] = 2;
                calcularMediaDoisValores(nota1, nota3, faltaUnidades);
            } else if (taVazio(input3)) {
                double nota1 = Double.parseDouble(input1.getText().toString());
                double nota2 = Double.parseDouble(input2.getText().toString());
                faltaUnidades[0] = 3;
                calcularMediaDoisValores(nota1, nota2, faltaUnidades);
            }

        }

    }

    public boolean taVazio(EditText input) {
        if (input.getText().toString().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }


    public void calcularMediaDoisValores(double val1, double val2, int faltaUnidades[]) {
        double faltaMedia = (7 * 3) - (val1 + val2);
        double faltaMediaNota = (5 * 3) - (val1 + val2);
        if (faltaMedia<0){
         faltaMedia=0;
        }
        if (faltaMediaNota<0){
            faltaMediaNota=0;
        }

        Toast.makeText(getActivity(), "Com " + faltaMedia + " na " + faltaUnidades[0] + "ª você será aprovado por média e com " + faltaMediaNota + " por nota", Toast.LENGTH_LONG).show();
        outputCondicao.setText("Situação: " + "Com " + faltaMedia + " na " + faltaUnidades[0] + "ª você será aprovado por média e com " + faltaMediaNota + " por nota");
    }

    public void calcularMediaUmValor(double val, int[] faltaUnidades) {
        double faltaMedia = (7 * 3) - (val);
        double faltaMediaNota = (5 * 3) - (val);
        Toast.makeText(getActivity(), "Com " + faltaMedia / 2 + " na " + faltaUnidades[0] + "ª e " + faltaUnidades[1] + "ª você será aprovado por média e com " + faltaMediaNota / 2 + " por nota", Toast.LENGTH_LONG).show();
        outputCondicao.setText("Situação: " + "Com " + faltaMedia / 2 + " na " + faltaUnidades[0] + "ª e " + faltaUnidades[1] + "ª você será aprovado por média e com " + faltaMediaNota / 2 + " por nota");
    }


}
