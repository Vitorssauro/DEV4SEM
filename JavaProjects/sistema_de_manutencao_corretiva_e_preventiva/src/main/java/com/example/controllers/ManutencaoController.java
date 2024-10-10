package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.api.ManutencaoAPI;
import com.example.models.Manutencao;

public class ManutencaoController {
    private List<Manutencao> manutencoes;

    public ManutencaoController() {
        manutencoes = new ArrayList<>();
    }

    // Métodos - CRUD
    public void createManutencao(Manutencao manutencao) {
        this.manutencoes.add(manutencao);
    }

    public List<Manutencao> readManutencoes() {
        manutencoes = ManutencaoAPI.getManutencoes();
        return manutencoes;
    }

    public void updateManutencao(int posicao, Manutencao manutencao) {
        manutencoes.set(posicao, manutencao);
    }

    public void deleteManutencao(int posicao) {
        manutencoes.remove(posicao);
    }
}
