package br.com.codeit_airlines;

import br.com.codeit_airlines.cenario.AeroportoBuilder;
import br.com.codeit_airlines.cenario.AeroportoBuilder.Aeroporto;
import br.com.codeit_airlines.cenario.Aviao;
import br.com.codeit_airlines.cenario.SmartFortwo;
import br.com.codeit_airlines.personagem.*;

public class Application {
    public static void main(String[] args){
        Aeroporto aeroporto = new AeroportoBuilder()
                .withComissaria(new Comissaria("Comissaria 1"))
                .withComissaria(new Comissaria("Comissaria 2"))
                .withOficial(new Oficial("Oficial 1"))
                .withOficial(new Oficial("Oficial 2"))
                .withPiloto(new Piloto("Piloto"))
                .withPolicial(new Policial("Policial"))
                .withPresidiario(new Presidiario("Presidiario"))
                .withChefeDeServicoDeVoo(new ChefeDeServicoDeVoo("Chefe de Serviço de Voo"))
                .build();

        Desafio desafio = new Desafio(new SmartFortwo(), aeroporto, new Aviao());
        desafio.resolver();
    }
}
