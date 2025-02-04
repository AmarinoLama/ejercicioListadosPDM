package com.example.listados;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AnimalViewModel extends ViewModel {
    private final MutableLiveData<Animal> animalSeleccionado = new MutableLiveData<>();

    public LiveData<Animal> getAnimalSeleccionado() {
        return animalSeleccionado;
    }

    public void setAnimalSeleccionado(Animal animal) {
        animalSeleccionado.setValue(animal);
    }

    public void marcarVerificado() {
        if (animalSeleccionado.getValue() != null) {
            Animal animal = animalSeleccionado.getValue();
            animal.setVerificado(true);
            animalSeleccionado.setValue(animal);
        }
    }
}
