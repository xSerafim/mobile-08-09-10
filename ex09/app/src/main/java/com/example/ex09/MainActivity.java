package com.example.ex09;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            loadBundle(bundle);
        }
    }

    private void loadBundle(Bundle bundle) {
        String tipo = bundle.getString("tipo");

        assert tipo != null;
        if (tipo.equals("junior")) {
            fragment = new AtletaJuvenilFragment();
        }
        if (tipo.equals("adulto")) {
            fragment = new AtletaAdultoFragment();
        }
        if (tipo.equals("senior")) {
            fragment = new AtletaSeniorFragment();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutFragment, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, MainActivity.class);

        if (itemId == R.id.menu_atleta_juvenil) {
            bundle.putString("tipo", "junior");

            intent.putExtras(bundle);
            this.startActivity(intent);
            this.finish();

            return true;
        }

        if (itemId == R.id.menu_atleta_adulto) {
            bundle.putString("tipo", "adulto");

            intent.putExtras(bundle);
            this.startActivity(intent);
            this.finish();

            return true;

        }
        if (itemId == R.id.menu_atleta_senior) {
            bundle.putString("tipo", "senior");

            intent.putExtras(bundle);
            this.startActivity(intent);
            this.finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}