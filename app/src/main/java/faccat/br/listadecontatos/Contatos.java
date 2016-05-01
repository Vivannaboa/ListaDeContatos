package faccat.br.listadecontatos;

/**
 * ClassName Contatos
 * Responsavel por tipar a entidade contato.
 */

public class Contatos {
    //Atributos
    private String nome;
    private String fone;

    //Contrutor
    public Contatos(String nome, String fone) {
        this.nome = nome;
        this.fone = fone;
    }
    //Métodos
    public String getNome() {
        return nome;
    }
    public String getFone() {
        return fone;
    }
    @Override
    public String toString() {
        return  nome + " - " + fone  ;
    }
}
