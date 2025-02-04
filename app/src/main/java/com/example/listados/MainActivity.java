package com.example.listados;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerAnimales;
    RecyclerView rv;

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

        rv = findViewById(R.id.reciclerView1);

        rv.setLayoutManager(new LinearLayoutManager(this) {});

        rv.setAdapter(new RecyclerView.Adapter() {

            private List<Animal> animales = new ArrayList<>(
                    List.of(
                            new Animal("perro", R.drawable.perro),
                            new Animal("gato", R.drawable.gato),
                            new Animal("caballo", R.drawable.caballo),
                            new Animal("ballena", R.drawable.ballena),
                            new Animal("aguila", R.drawable.aguila)
                    )
            );

            class MyViewHolder extends RecyclerView.ViewHolder {

                ImageView img1;
                TextView txt1, txtVerificar;
                Button button1;

                public MyViewHolder(@NotNull View itemView) {
                    super(itemView);
                    img1 = itemView.findViewById(R.id.img1);
                    txt1 = itemView.findViewById(R.id.txt1);
                    txtVerificar = itemView.findViewById(R.id.txtVerificar);
                    button1 = itemView.findViewById(R.id.btn1);

                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(v.getContext(), Activity2.class);

                            Animal animal = animales.get(getAdapterPosition());
                            intent.putExtra("animal", animal);

                            startActivity(intent);
                        }
                    });
                }

                public ImageView getImg1() {
                    return img1;
                }

                public TextView getTxt1() {
                    return txt1;
                }

                public Button getButton1() {
                    return button1;
                }

                public TextView getTxtVerificar() {
                    return txtVerificar;
                }
            }

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fragment_tarjeta_animal, parent, false);
                return new MyViewHolder(view);
            }

            @Override
            public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
                MyViewHolder vh = (MyViewHolder) holder;

                Animal animal = animales.get(position);
                vh.getTxt1().setText(animal.getNombre());
                vh.getImg1().setImageResource(animal.getImagen());
                vh.getTxtVerificar().setText(animal.isSeleccionado() ? "Verificado" : "No verificado");
            }

            @Override
            public int getItemCount() {
                return 5;
            }
        });
    }
}