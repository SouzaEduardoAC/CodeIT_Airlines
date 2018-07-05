package br.com.codeit_airlines.personagem;

import org.junit.Assert;
import org.junit.Test;

public class PersonagemTest {

    @Test
    void testToString(){
        Oficial oficial = new Oficial("123");
        Assert.assertEquals(oficial.toString(), "Oficial {nome='123'} ");
    }
}
