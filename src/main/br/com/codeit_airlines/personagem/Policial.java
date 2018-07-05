package br.com.codeit_airlines.personagem;

public class Policial extends Personagem implements DirigeSmartFortwo {
    public Policial(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return "Policial {" +
                "nome='" + nome + '\'' +
                "} ";
    }
}
