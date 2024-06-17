package com.example.ex08;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ex08.model.Ticket;
import com.example.ex08.model.TicketVIP;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroupTipoIngresso;
    private RadioButton radioButtonNormal, radioButtonVIP;
    private EditText editTextCodigo, editTextValor, editTextFuncao, editTextTaxa;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupTipoIngresso = findViewById(R.id.radioGroupTipoIngresso);
        radioButtonNormal = findViewById(R.id.radioButtonNormal);
        radioButtonVIP = findViewById(R.id.radioButtonVIP);
        editTextCodigo = findViewById(R.id.editTextCodigo);
        editTextValor = findViewById(R.id.editTextValor);
        editTextFuncao = findViewById(R.id.editTextFuncao);
        editTextTaxa = findViewById(R.id.editTextTaxa);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularValorFinal();
            }
        });
    }

    private void calcularValorFinal() {
        String codigo = editTextCodigo.getText().toString();
        float valor = Float.parseFloat(editTextValor.getText().toString());
        float taxa = Float.parseFloat(editTextTaxa.getText().toString());

        Ticket ingresso;
        if (radioButtonNormal.isChecked()) {
            ingresso = new Ticket(codigo, valor);
        } else {
            String funcao = editTextFuncao.getText().toString();
            ingresso = new TicketVIP(codigo, valor, funcao);
        }

        float valorFinal = ingresso.valorFinal(taxa);

        Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
        intent.putExtra("resultado", formatarResultado(ingresso, valorFinal));
        startActivity(intent);
    }

    private String formatarResultado(Ticket ingresso, float valorFinal) {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Código: ").append(ingresso.getCodigo()).append("\n");
        resultado.append("Valor: R$ ").append(String.format("%.2f", ingresso.getValor())).append("\n");
        if (ingresso instanceof TicketVIP) {
            TicketVIP vip = (TicketVIP) ingresso;
            resultado.append("Função: ").append(vip.getCargo()).append("\n");
        }
        resultado.append("Valor Final: R$ ").append(String.format("%.2f", valorFinal));
        return resultado.toString();
    }
}