package com.coding4world.salarycalculator;

import org.junit.Test;

import static com.coding4world.salarycalculator.IRRF.instance;
import static org.junit.Assert.assertEquals;

public class IRRFUnitTest {

    @Test
    public void getAliquota_7_5_isCorreto() {
        double result = instance.getValorContribuicao(0,3000.00,
                INSS.instance.getValorContribuicao(3000.00));
        assertEquals( 8.28, result, 1);
    }
}
