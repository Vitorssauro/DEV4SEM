package com.example;

public class Main {
    public static void main(String[] args) {
        UsuarioController uc = new UsuarioController();
        uc.create(new Usuario("", "Pedro", 35, "Rua a"));
        uc.read();
    }
}