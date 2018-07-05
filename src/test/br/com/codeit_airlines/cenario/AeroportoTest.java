package br.com.codeit_airlines.cenario;

import br.com.codeit_airlines.cenario.AeroportoBuilder.Aeroporto;
import br.com.codeit_airlines.personagem.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

class AeroportoTest {

    @Test
    void testAeoroportoGetPersonagens(){
        Aeroporto aeroporto = this.getAeroporto();
        List<Personagem> personagens = aeroporto.getPersonagens();
        Assert.assertEquals(personagens.size() , 8);
    }

    @Test
    void testAeroportoGetChefeDeServicoDeVoo(){
        Aeroporto aeroporto = this.getAeroporto();
        Assert.assertEquals(aeroporto.getChefeServicoVoo().getClass(), ChefeDeServicoDeVoo.class);
    }

    @Test
    void testAeroportoGetPiloto(){
        Aeroporto aeroporto = this.getAeroporto();
        Assert.assertEquals(aeroporto.getPiloto().getClass(), Piloto.class);
    }

    @Test
    void testAeroportoAdicionarPersonagem(){
        Aeroporto aeroporto = this.getAeroporto();
        aeroporto.adicionarPersonagem(new Oficial("novo oficial"));
        Assert.assertEquals(aeroporto.getPersonagens().size(), 9);
    }

    @Test
    void testAeroportoEmbarcarPersonagem(){
        Aeroporto aeroporto = this.getAeroporto();
        aeroporto.embarcar(aeroporto.getChefeServicoVoo());
        Assert.assertEquals(aeroporto.getPersonagens().size(), 7);
    }

    @Test
    void testAcompanhanteOficial(){
        Aeroporto aeroporto = this.getAeroporto();
        Assert.assertEquals(aeroporto.getAcompanhante(aeroporto.getPiloto()).getClass(), Oficial.class);
    }

    @Test
    void testMotoristaFortwo(){
        Aeroporto aeroporto = this.getAeroporto();
        Personagem motoristaAutorizado = aeroporto.getMotoristaAutorizado();
        Assert.assertTrue(motoristaAutorizado instanceof DirigeSmartFortwo);
    }

    @Test
    void testAcompanhantePolicial(){
        Aeroporto aeroporto = this.getAeroporto();
        Policial policial = new Policial("123");
        Personagem acompanhante = aeroporto.getAcompanhante(policial);
        Assert.assertEquals(acompanhante.getClass(), Presidiario.class);
    }

    @Test
    void testAcompanhanteChefeVoo(){
        Aeroporto aeroporto = this.getAeroporto();
        ChefeDeServicoDeVoo chefeServicoVoo = aeroporto.getChefeServicoVoo();
        Personagem acompanhante = aeroporto.getAcompanhante(chefeServicoVoo);
        Assert.assertEquals(acompanhante.getClass(), Comissaria.class);
    }

    private Aeroporto getAeroporto(){
        return new AeroportoBuilder()
                .withComissaria(new Comissaria("Comissaria 1"))
                .withComissaria(new Comissaria("Comissaria 2"))
                .withOficial(new Oficial("Oficial 1"))
                .withOficial(new Oficial("Oficial 2"))
                .withPiloto(new Piloto("Piloto"))
                .withPolicial(new Policial("Policial"))
                .withPresidiario(new Presidiario("Presidiario"))
                .withChefeDeServicoDeVoo(new ChefeDeServicoDeVoo("Chefe de Serviço de Voo"))
                .build();
    }
}
