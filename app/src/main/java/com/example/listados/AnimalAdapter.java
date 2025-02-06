package com.example.listados;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.MyViewHolder> {

    private List<Animal> animales;
    private Context context;

    public AnimalAdapter(Context context, List<Animal> animales) {
        this.context = context;
        this.animales = animales;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img1;
        TextView txt1, txtVerificar;
        Button button1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img1 = itemView.findViewById(R.id.img1);
            txt1 = itemView.findViewById(R.id.txt1);
            txtVerificar = itemView.findViewById(R.id.txtVerificar);
            button1 = itemView.findViewById(R.id.btn1);

            button1.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Animal animal = animales.get(position);
                    Intent intent = new Intent(context, Activity2.class);
                    intent.putExtra("animal", animal);
                    ((MainActivity) context).startActivityForResult(intent, 1);
                }
            });
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_tarjeta_animal, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Animal animal = animales.get(position);
        holder.txt1.setText(animal.getNombre());
        holder.img1.setImageResource(animal.getImagen());
        holder.txtVerificar.setText(animal.isSeleccionado() ? "Verificado" : "No verificado");
    }

    @Override
    public int getItemCount() {
        return animales.size();
    }

    public void actualizarLista(List<Animal> nuevaLista) {
        this.animales = nuevaLista;
        notifyDataSetChanged();
    }
}
