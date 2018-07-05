package br.com.codeit_airlines.cenario;

import br.com.codeit_airlines.personagem.*;
import java.util.ArrayList;
import java.util.List;

public class AeroportoBuilder{
    private List<Personagem> personagens = new ArrayList<>();


    public AeroportoBuilder withPiloto(Piloto piloto){
        this.personagens.add(piloto);
        return this;
    }

    public AeroportoBuilder withComissaria(Comissaria comissaria){
        this.personagens.add(comissaria);
        return this;
    }

    public AeroportoBuilder withChefeDeServicoDeVoo(ChefeDeServicoDeVoo chefeDeServicoDeVoo){
        this.personagens.add(chefeDeServicoDeVoo);
        return this;
    }

    public AeroportoBuilder withOficial(Oficial oficial){
        this.personagens.add(oficial);
        return this;
    }

    public AeroportoBuilder withPolicial(Policial policial){
        this.personagens.add(policial);
        return this;
    }

    public AeroportoBuilder withPresidiario(Presidiario presidiario){
        this.personagens.add(presidiario);
        return this;
    }

    public Aeroporto build(){
        return new Aeroporto(this);
    }

    public class Aeroporto {
        private List<Personagem> personagens;

        Aeroporto(AeroportoBuilder aeroportoBuilder){
            this.personagens = aeroportoBuilder.personagens;
        }

        public List<Personagem> getPersonagens() {
            return personagens;
        }

        public Personagem getMotoristaAutorizado(){
            return this.personagens
                    .stream()
                    .filter(p -> p instanceof DirigeSmartFortwo)
                    .findFirst()
                    .get();
        }

        public Personagem getAcompanhante(DirigeSmartFortwo motoristaFortwo){
            if (motoristaFortwo instanceof Policial) return getPresidiario();
            else if (motoristaFortwo instanceof Piloto) return getOficial();
            else return getComissaria();
        }

        private Comissaria getComissaria() {
            return getByClass(Comissaria.class);
        }

        private Oficial getOficial() {
            return getByClass(Oficial.class);
        }

        private Presidiario getPresidiario(){
            return getByClass(Presidiario.class);
        }

        public Piloto getPiloto() {
            return getByClass(Piloto.class);
        }

        public ChefeDeServicoDeVoo getChefeServicoVoo() {
            return getByClass(ChefeDeServicoDeVoo.class);
        }

        private <T extends Personagem> T getByClass(Class<T> classe) {
            return (T) this.personagens
                    .stream()
                    .filter(p -> classe.isInstance(p))
                    .findFirst()
                    .get();
        }

        public void adicionarPersonagem(Personagem motorista) {
            this.personagens.add(motorista);
        }

        public void embarcar(Personagem motorista) {
            this.personagens.remove(motorista);
        }
    }
}

