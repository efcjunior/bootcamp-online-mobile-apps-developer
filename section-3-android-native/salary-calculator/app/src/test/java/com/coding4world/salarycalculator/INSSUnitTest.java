package com.coding4world.salarycalculator;

import org.junit.Test;

import static com.coding4world.salarycalculator.INSS.instance;
import static org.junit.Assert.assertEquals;

public class INSSUnitTest {

    @Test
    public void getAliquota_7_5_isCorreto() {
        double result = instance.getValorContribuicao( 1045.00);
        assertEquals(78.375, result, 0);
    }

    @Test
    public void getAliquota_9_isCorreto() {
        double result = instance.getValorContribuicao(  2089.60);
        assertEquals(172.394, result, 0);
    }

    @Test
    public void getAliquota_12_isCorreto() {
        double result = instance.getValorContribuicao(  2089.61 );
        assertEquals(172.3932, result, 1);
    }

    @Test
    public void getAliquota_14_isCorreto() {
        double result = instance.getValorContribuicao(   6101.06 );
        assertEquals(713.0984, result, 1);
    }


    @Test
    public void getContribuicaoMaxima_isCorreto() {
        double result = instance.getValorContribuicao(9856.00);
        assertEquals(713.1, result, 0);
    }
}
