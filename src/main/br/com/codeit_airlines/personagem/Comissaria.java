package br.com.codeit_airlines.personagem;

public class Comissaria extends StaffCabine {
    public Comissaria(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return "Comissaria {" +
                "nome='" + nome + '\'' +
                "} ";
    }
}
