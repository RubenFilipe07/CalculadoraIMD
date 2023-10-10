package com.rubenfilipe07.calculadoraimd;

import static java.lang.Integer.parseInt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Calculadora extends Fragment {

    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnMais;
    private Button btnMenos;
    private Button btnMulti;
    private Button btnDiv;
    private Button btnDel;
    private Button btnIgual;
    private TextView outputCalculadora;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculadora, container, false);

        btn0 = view.findViewById(R.id.btn0);
        btn1 = view.findViewById(R.id.btn1);
        btn2 = view.findViewById(R.id.btn2);
        btn3 = view.findViewById(R.id.btn3);
        btn4 = view.findViewById(R.id.btn4);
        btn5 = view.findViewById(R.id.btn5);
        btn6 = view.findViewById(R.id.btn6);
        btn7 = view.findViewById(R.id.btn7);
        btn8 = view.findViewById(R.id.btn8);
        btn9 = view.findViewById(R.id.btn9);
        btnMais = view.findViewById(R.id.btnmais);
        btnMenos = view.findViewById(R.id.btnmenos);
        btnMulti = view.findViewById(R.id.btnmulti);
        btnDiv = view.findViewById(R.id.btndiv);
        btnDel = view.findViewById(R.id.btndel);
        btnIgual = view.findViewById(R.id.btnigual);
        outputCalculadora = view.findViewById(R.id.outputCalculadora);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputCalculadora.setText(outputCalculadora.getText() + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputCalculadora.setText(outputCalculadora.getText() + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputCalculadora.setText(outputCalculadora.getText() + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputCalculadora.setText(outputCalculadora.getText() + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputCalculadora.setText(outputCalculadora.getText() + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputCalculadora.setText(outputCalculadora.getText() + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputCalculadora.setText(outputCalculadora.getText() + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputCalculadora.setText(outputCalculadora.getText() + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputCalculadora.setText(outputCalculadora.getText() + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputCalculadora.setText(outputCalculadora.getText() + "9");
            }
        });

        btnMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputCalculadora.setText(outputCalculadora.getText() + "+");
            }
        });

        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputCalculadora.setText(outputCalculadora.getText() + "-");
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputCalculadora.setText(outputCalculadora.getText() + "*");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputCalculadora.setText(outputCalculadora.getText() + "/");
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputCalculadora.setText("Resultado: ");
            }
        });

        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultado = outputCalculadora.getText().toString();
                resultado = resultado.replace("Resultado: ", "");

                try {
                    String[] tokensRegex = resultado.split("(?=[+\\-*/])|(?<=[+\\-*/])");

                    double resultadoFinal = Double.parseDouble(tokensRegex[0]);

                    for (int i = 1; i < tokensRegex.length - 1; i += 2) {
                        char operador = tokensRegex[i].charAt(0);
                        double numero = Double.parseDouble(tokensRegex[i + 1]);

                        switch (operador) {
                            case '+':
                                resultadoFinal += numero;
                                break;
                            case '-':
                                resultadoFinal -= numero;
                                break;
                            case '*':
                                resultadoFinal *= numero;
                                break;
                            case '/':
                                if (numero == 0) {
                                    outputCalculadora.setText("Resultado: ");
                                    Toast.makeText(getActivity(), "Operação não permitida", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                                resultadoFinal /= numero;
                                break;
                            default:
                                outputCalculadora.setText("Resultado: ");
                                Toast.makeText(getActivity(), "Operação não permitida", Toast.LENGTH_SHORT).show();
                                return;
                        }
                    }

                    outputCalculadora.setText("Resultado: " + resultadoFinal);

                } catch (Exception e) {
                    outputCalculadora.setText("Resultado: ");
                    Toast.makeText(getActivity(), "Operação não permitida", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
