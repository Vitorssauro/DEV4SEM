package com.example;

public class ContatoController {
    // Atributos
    private Contato[] contatos;
    private int contadorDeContatos;

    // construtor
    public ContatoController(int maxContato) {
        maxContato = 100;
        contatos = new Contato[maxContato];
        contadorDeContatos = 0;
    }

    // métodos - adicionar contato
    public void addContato(Contato contato) throws AgendaCheiaException {
        if (contadorDeContatos >= contatos.length) {
            throw new AgendaCheiaException("Agenda Cheia!");
        }
        try {
            contatos[contadorDeContatos] = contato;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // métodos - Listar Todos
    public void listarContato() {
        if (contadorDeContatos == 0) {
            System.out.println("Agenda Vazia");
        } else {
            for (int i = 0; i < contadorDeContatos; i++) {
                if (contatos[i]!=null) {
                System.out.println(contatos[i].toString());
                    
                }
            }
        }
    }

    // métodos - Buscar Contato pelo nome
    public Contato buscarContato(String nome) throws ContatoNaoEncontrado{
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                return contatos[i];
            }
        }
        throw new ContatoNaoEncontrado("Contato não encontrado");
    }

}
