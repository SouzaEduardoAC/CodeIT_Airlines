package br.com.codeit_airlines.personagem;

public class Piloto extends StaffTecnica implements DirigeSmartFortwo {
    public Piloto(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return "Piloto {" +
                "nome='" + nome + '\'' +
                "} ";
    }
}
