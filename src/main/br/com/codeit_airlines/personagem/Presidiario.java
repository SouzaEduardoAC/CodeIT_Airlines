package br.com.codeit_airlines.personagem;

public class Presidiario extends Personagem {
    public Presidiario(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return "Presidiario {" +
                "nome='" + nome + '\'' +
                "} ";
    }
}
