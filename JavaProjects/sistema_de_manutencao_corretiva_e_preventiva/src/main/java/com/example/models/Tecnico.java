package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Tecnico {
    private String id;
    private String nome;
    private String especialidade;
    private String disponibilidade;
}
