package com.example.listados;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    AnimalViewModel animalViewModel;
    AnimalAdapter adapter;

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

        // Inicializar RecyclerView
        rv = findViewById(R.id.reciclerView1);
        rv.setLayoutManager(new LinearLayoutManager(this));

        // Inicializar ViewModel
        animalViewModel = new ViewModelProvider(this).get(AnimalViewModel.class);

        // Crear y asignar el adaptador al RecyclerView
        adapter = new AnimalAdapter(this, animalViewModel.getListaAnimales().getValue());
        rv.setAdapter(adapter);

        // Observar los cambios en los datos
        animalViewModel.getListaAnimales().observe(this, animales -> adapter.actualizarLista(animales));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String nombreVerificado = data.getStringExtra("animalVerificado");
            animalViewModel.marcarComoVerificado(nombreVerificado);
        }
    }
}
