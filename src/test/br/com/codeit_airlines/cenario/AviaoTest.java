package br.com.codeit_airlines.cenario;

import br.com.codeit_airlines.personagem.ChefeDeServicoDeVoo;
import br.com.codeit_airlines.personagem.Policial;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class AviaoTest {

    @Test
    void embarcar() {
        Aviao aviao = new Aviao();
        aviao.embarcar(new Policial("policial"));
        Assert.assertEquals(aviao.getPassageiros().get(0).getClass(), Policial.class);
    }

    @Test
    void desembarcarMotoristaAutorizado() {
        Aviao aviao = new Aviao();
        aviao.embarcar(new ChefeDeServicoDeVoo("chefe de voo"));
        aviao.desembarcarMotoristaAutorizado();
        Assert.assertEquals(aviao.getPassageiros().size(), 0);
    }
}