package com.example.ex09;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ex09.model.AtletaJuvenil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AtletaJuvenilFragment extends Fragment {

    private EditText editTextNome;
    private EditText editTextDataNascimento;
    private EditText editTextEndereco;
    private EditText editTextAnosPraticando;
    private Button btnCadastrar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_atleta_juvenil, container, false);

        editTextNome = view.findViewById(R.id.editTextNome);
        editTextDataNascimento = view.findViewById(R.id.editTextDataNascimento);
        editTextEndereco = view.findViewById(R.id.editTextEndereco);
        editTextAnosPraticando = view.findViewById(R.id.editTextAnosPraticando);
        btnCadastrar = view.findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarAtleta();
            }
        });

        return view;
    }

    private void cadastrarAtleta() {
        String nome = editTextNome.getText().toString();
        String dataNascimentoStr = editTextDataNascimento.getText().toString();
        String endereco = editTextEndereco.getText().toString();
        int anosPraticando = 0;
        try {
            anosPraticando = Integer.parseInt(editTextAnosPraticando.getText().toString());
        } catch (NumberFormatException e) {
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);

        AtletaJuvenil atletaJuvenil = new AtletaJuvenil(nome, dataNascimento, endereco, anosPraticando);

        Toast.makeText(getContext(), atletaJuvenil.toString(), Toast.LENGTH_SHORT).show();
    }
}