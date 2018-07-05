package br.com.codeit_airlines.cenario;

import br.com.codeit_airlines.personagem.DirigeSmartFortwo;
import br.com.codeit_airlines.personagem.Personagem;

public class SmartFortwo {
    public void transportar(DirigeSmartFortwo personagem) {
        System.out.println("Levando Motorista " + personagem.toString() + "ao aeroporto");
    }

    public void transportar(DirigeSmartFortwo motorista, Personagem acompanhante) {
        System.out.println("Levanto Motorista " + motorista.toString() + "e Acompanhante " + acompanhante.toString() + "ao avião");
    }
}
