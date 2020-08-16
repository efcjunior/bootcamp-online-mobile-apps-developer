package com.coding4world.salarycalculator;

public class Calculo {

    @FunctionalInterface
    interface MathOperation {
        double operation(double number1, double number2);
    }

    private static double operate(double a, double b, MathOperation mathOperation)
    {
        return mathOperation.operation(a, b);
    }

    public static double getDeducao(RegraContribuicao regra, final Double salarioBase){
        MathOperation calcAliquota =
                (valorSalario, valorAliquota) -> (valorSalario * valorAliquota);

        MathOperation calcDeducao =
                (valorAliquota, valorDeducao) -> (valorAliquota - valorDeducao);

        double valorDeducaoCalculado = 0.00;

        if(regra.getAliquota() > 0.00){
            valorDeducaoCalculado = operate(salarioBase, regra.getAliquota(), calcAliquota);
            valorDeducaoCalculado = operate(valorDeducaoCalculado, regra.getDeducao(), calcDeducao);
        }else {
            valorDeducaoCalculado = regra.getDeducao();
        }

        return valorDeducaoCalculado;
    }

    public static double getSalarioLiquido(final double salarioBruto, final double... descontos){
        double salarioLiquido = salarioBruto;
        for(int i = 0; i < descontos.length; i++){
            salarioLiquido = salarioLiquido - descontos[i];
        }
        return salarioLiquido;
    }
}
