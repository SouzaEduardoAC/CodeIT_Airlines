package br.com.codeit_airlines.personagem;

import br.com.codeit_airlines.cenario.AeroportoBuilder.Aeroporto;
import br.com.codeit_airlines.cenario.Aviao;
import br.com.codeit_airlines.cenario.SmartFortwo;

public class Desafio {
    private SmartFortwo smartFortwo;
    private Aviao aviao;
    private Aeroporto aeroporto;

    public Desafio(SmartFortwo smartFortwo, Aeroporto aeroporto, Aviao aviao){
        this.aeroporto = aeroporto;
        this.aviao = aviao;
        this.smartFortwo = smartFortwo;
    }

    public void resolver() {
        this.embarcar();

        if(aeroporto.getPersonagens().size() <= 0) return;

        this.desembarcar();
        resolver();
    }

    private void embarcar(){
        Personagem motorista = getMotorista();
        Personagem acompanhante = getAcompanhante((DirigeSmartFortwo) motorista);

        aeroporto.embarcar(motorista);
        aeroporto.embarcar(acompanhante);
        smartFortwo.transportar((DirigeSmartFortwo) motorista, acompanhante);
        aviao.embarcar(motorista);
        aviao.embarcar(acompanhante);
    }

    private Personagem getAcompanhante(DirigeSmartFortwo motorista){
        Personagem acompanhante;
        if(aeroporto.getPersonagens().size() == 8){
            acompanhante = aeroporto.getChefeServicoVoo();
        } else if (aeroporto.getPersonagens().size() > 2){
            acompanhante = aeroporto.getAcompanhante(motorista);
        } else {
            acompanhante = aeroporto.getPersonagens().get(1);
        }
        return acompanhante;
    }

    private Personagem getMotorista() {
        Personagem motorista;
        if(aeroporto.getPersonagens().size() == 8){
            motorista = aeroporto.getPiloto();
        } else if (aeroporto.getPersonagens().size() > 2){
            motorista = aeroporto.getMotoristaAutorizado();
        } else {
            motorista = aeroporto.getPersonagens().get(0);
        }
        return motorista;
    }

    private void desembarcar(){
        Personagem motorista = aviao.desembarcarMotoristaAutorizado();
        smartFortwo.transportar((DirigeSmartFortwo) motorista);
        aeroporto.adicionarPersonagem(motorista);
    }



}
