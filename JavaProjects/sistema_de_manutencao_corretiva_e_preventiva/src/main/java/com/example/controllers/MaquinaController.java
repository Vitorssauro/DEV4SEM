package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.models.Maquina;;

public class MaquinaController {
    private List<Maquina> maquinas;

    public MaquinaController() {
        maquinas = new ArrayList<>();
    }

    // método CRUD
    public void createMaquina(Maquina maquina){
        this.maquinas.add(maquina);
    }

    public List<Maquina> readMaquinas(){
        return maquinas;
    }

    public void updateMaquina(int posicao, Maquina maquina){
        maquinas.set(posicao, maquina);
    }

    public void deleteMaquina(int posicao){
        maquinas.remove(posicao);
    }
}
