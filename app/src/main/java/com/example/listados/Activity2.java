package com.example.listados;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    private Button button;
    private ImageView ivImagen;
    private TextView tvNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        button = findViewById(R.id.btnVolver);
        ivImagen = findViewById(R.id.ivImagen);
        tvNombre = findViewById(R.id.tvNombre);

        Intent intent = getIntent();
        Animal animal = (Animal) intent.getSerializableExtra("animal");

        tvNombre.setText(animal.getNombre());
        ivImagen.setImageResource(animal.getImagen());

        button.setOnClickListener(v -> {
            Intent intentAct1 = new Intent(this, MainActivity.class);
            startActivity(intentAct1);
        });
    }
}