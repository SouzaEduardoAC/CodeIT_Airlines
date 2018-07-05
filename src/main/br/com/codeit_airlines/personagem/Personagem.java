package br.com.codeit_airlines.personagem;

public abstract class Personagem {
    String nome;

    Personagem(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Personagem {" +
                "nome='" + nome + '\'' +
                "} ";
    }
}
