package br.com.codeit_airlines.personagem;

public class Oficial extends StaffTecnica {
    public Oficial(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return "Oficial {" +
                "nome='" + nome + '\'' +
                "} ";
    }
}
