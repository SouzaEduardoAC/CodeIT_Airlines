package br.com.codeit_airlines.cenario;

import br.com.codeit_airlines.personagem.DirigeSmartFortwo;
import br.com.codeit_airlines.personagem.Personagem;
import br.com.codeit_airlines.personagem.Policial;
import java.util.ArrayList;
import java.util.List;

public class Aviao {
    private List<Personagem> passageiros;

    public Aviao(){
        this.passageiros = new ArrayList<>();
    }

    public List<Personagem> getPassageiros() {
        return passageiros;
    }

    public void embarcar(Personagem personagem){
        this.passageiros.add(personagem);
    }

    public Personagem desembarcarMotoristaAutorizado() {
        Personagem personagem = this.passageiros
                .stream()
                .filter(p -> p instanceof DirigeSmartFortwo && !(p instanceof Policial))
                .findFirst()
                .get();

        this.passageiros.remove(personagem);
        return personagem;
    }
}
