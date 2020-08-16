package com.coding4world.salarycalculator;

import java.util.ArrayList;
import java.util.List;

public class IRRF {
    private final static Double VALOR_POR_DEPENDENTE = 189.69;
    private List<RegraContribuicao> regrasContribuicao;
    public final static IRRF instance = getInstance();

    private IRRF(){
        this.regrasContribuicao = new ArrayList<>();
        this.regrasContribuicao.add(new RegraContribuicao(
                0.00, 1903.98, 0.00, 0.00));
        this.regrasContribuicao.add(new RegraContribuicao(
                1903.99 ,  2826.65, 0.075, 142.80));
        this.regrasContribuicao.add(new RegraContribuicao(
                2826.66,  3751.05, 0.15, 354.80));
        this.regrasContribuicao.add(new RegraContribuicao(
                3751.06,  4664.68, 0.225, 636.13));
        this.regrasContribuicao.add(new RegraContribuicao(
                4664.69 ,  null, 0.275,  869.36));
    }

    private static IRRF getInstance() {
        if(instance == null){
            return new IRRF();
        }
        return instance;
    }

    public double getValorContribuicao(int numeroDependentes, double salarioBruto, double valorInss){
        double salarioBase =  getSalarioBase(numeroDependentes,salarioBruto, valorInss);
        RegraContribuicaoPredicates  regraContruicaoPredicates =  new RegraContribuicaoPredicates();
        RegraContribuicao regraContribuicao = regraContruicaoPredicates.getRegraContribuicao(this.regrasContribuicao,
                salarioBase);
        return Calculo.getDeducao(regraContribuicao, salarioBase);
    }

    private double getSalarioBase(int numDependentes, final Double salarioBruto, double valorInss){
        return salarioBruto - valorInss - numDependentes * VALOR_POR_DEPENDENTE;
    }
}
