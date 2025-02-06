package com.example.listados;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class AnimalViewModel extends ViewModel {

    private final MutableLiveData<List<Animal>> listaAnimales = new MutableLiveData<>();

    public AnimalViewModel() {
        List<Animal> animales = new ArrayList<>();
        animales.add(new Animal("perro", R.drawable.perro));
        animales.add(new Animal("gato", R.drawable.gato));
        animales.add(new Animal("caballo", R.drawable.caballo));
        animales.add(new Animal("ballena", R.drawable.ballena));
        animales.add(new Animal("aguila", R.drawable.aguila));
        listaAnimales.setValue(animales);
    }

    public LiveData<List<Animal>> getListaAnimales() {
        return listaAnimales;
    }

    public void marcarComoVerificado(String nombreAnimal) {
        List<Animal> animales = new ArrayList<>(listaAnimales.getValue());
        for (Animal animal : animales) {
            if (animal.getNombre().equals(nombreAnimal)) {
                animal.setVerificado(true);
                break;
            }
        }
        listaAnimales.setValue(animales);
    }
}