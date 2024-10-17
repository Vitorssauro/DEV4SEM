package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.api.TecnicoAPI;
import com.example.models.Tecnico;

public class TecnicoController {
    private List<Tecnico> tecnicos;

    public TecnicoController() {
        tecnicos = new ArrayList<>();
    }

    // Métodos - CRUD
    public void createTecnico(Tecnico tecnico) {
        this.tecnicos.add(tecnico);
    }

    public List<Tecnico> readTecnicos() {
        tecnicos = TecnicoAPI.getTecnicos();
        return tecnicos;
    }

    public void updateTecnico(int posicao, Tecnico tecnico) {
        tecnicos.set(posicao, tecnico);
    }

    public void deleteTecnico(int posicao) {
        tecnicos.remove(posicao);
    }
}
