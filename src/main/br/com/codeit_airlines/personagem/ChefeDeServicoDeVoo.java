package br.com.codeit_airlines.personagem;

public class ChefeDeServicoDeVoo extends StaffCabine implements DirigeSmartFortwo {
    public ChefeDeServicoDeVoo(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return "ChefeDeServicoDeVoo {" +
                "nome='" + nome + '\'' +
                "} ";
    }
}
