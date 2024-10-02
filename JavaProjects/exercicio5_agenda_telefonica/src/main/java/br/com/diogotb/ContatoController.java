package br.com.diogotb;
//controller
public class ContatoController {
    //Atributos
    private Contato[] contatos;
    private int contadorDeContatos;

    //construtor
    public ContatoController(int maxContato) {
        contatos = new Contato[maxContato];
        contadorDeContatos = 0;
    }

    //métodos - adicionar contato
    public void addContato(Contato contato) throws AgendaCheiaException{
        if(contadorDeContatos>=contatos.length){
            throw new AgendaCheiaException("Agenda cheia");
        }
        try {
            contatos[contadorDeContatos]=contato;
            contadorDeContatos++;
            System.out.println("Contato Adicionado");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    //métodos - Listar Todos os Contatos
    public void listarContato(){
        if (contadorDeContatos ==0) {
            System.out.println("Agenda Vazia");
        }else{
            for (int i = 0; i < contadorDeContatos; i++) {
                System.out.println(contatos[i].toString());
            }
        }
    }
    //buscar contato
    public Contato buscarContato(String nome) throws ContatoNaoEncontrado{
        for (int i = 0; i < contadorDeContatos; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                return contatos[i];
            }
        }
        throw new ContatoNaoEncontrado("Contato não Encontrado");
    }
    
    //remover contato
    public void removerContato(String nome) throws ContatoNaoEncontrado{
        boolean encontrado = false;
        for (int i = 0; i < contadorDeContatos; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                encontrado = true;
                contatos[i]=contatos[contadorDeContatos-1];
                contatos[contadorDeContatos-1]=null;
                contadorDeContatos--;
            }
        }
        if (!encontrado) {
            throw new ContatoNaoEncontrado("Contato não Encontrado");
        }
    }

}
