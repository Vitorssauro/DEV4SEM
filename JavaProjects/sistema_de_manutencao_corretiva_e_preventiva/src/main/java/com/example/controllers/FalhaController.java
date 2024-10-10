package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.api.FalhaAPI;
import com.example.models.Falha;

public class FalhaController {
    private List<Falha> falhas;

    public FalhaController() {
        falhas = new ArrayList<>();
    }

    // Métodos - CRUD
    public void createFalha(Falha falha) {
        this.falhas.add(falha);
    }

    public List<Falha> readFalhas() {

        falhas = FalhaAPI.getFalhas();
        return falhas;
    }

    public void updateFalha(int posicao, Falha falha) {
        falhas.set(posicao, falha);
    }

    public void deleteFalha(int posicao) {
        falhas.remove(posicao);
    }
}
