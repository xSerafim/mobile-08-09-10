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

import com.example.ex09.model.AtletaAdulto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AtletaAdultoFragment extends Fragment {

    private EditText editTextNome;
    private EditText editTextDataNascimento;
    private EditText editTextEndereco;
    private EditText editTextAcademia;
    private EditText editTextRecorde;
    private Button btnCadastrar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_atleta_adulto, container, false);

        editTextNome = view.findViewById(R.id.editTextNome);
        editTextDataNascimento = view.findViewById(R.id.editTextDataNascimento);
        editTextEndereco = view.findViewById(R.id.editTextEndereco);
        editTextAcademia = view.findViewById(R.id.editTextAcademia);
        editTextRecorde = view.findViewById(R.id.editTextRecorde);
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
        String academia = editTextAcademia.getText().toString();
        int recorde = 0;
        try {
            recorde = Integer.parseInt(editTextRecorde.getText().toString());
        } catch (NumberFormatException e) {

        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);

        AtletaAdulto atletaAdulto = new AtletaAdulto(nome, dataNascimento, endereco, academia, recorde);

        Toast.makeText(getContext(), atletaAdulto.toString(), Toast.LENGTH_SHORT).show();
    }
}