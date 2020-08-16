package com.coding4world.salarycalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculoUnitTest {

    @Test
    public void getSalarioLiquido_isCorreto() {
        double salarioBruto = 3123.00;
        int numeroDependentes = 1;
        double valorInss = INSS.instance.getValorContribuicao(salarioBruto);
        double valorIRRF = IRRF.instance.getValorContribuicao(numeroDependentes, salarioBruto, valorInss);
        double result = Calculo.getSalarioLiquido(salarioBruto, valorInss, valorIRRF);
        assertEquals( 8.28, result, 1);
    }
}
