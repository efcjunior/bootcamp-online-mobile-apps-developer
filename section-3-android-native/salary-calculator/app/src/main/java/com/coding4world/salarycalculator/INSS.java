package com.coding4world.salarycalculator;

import java.util.ArrayList;
import java.util.List;

public class INSS {

    private List<RegraContribuicao> regrasContribuicao;
    public final static INSS instance = getInstance();

    private INSS() {
        this.regrasContribuicao = new ArrayList<>();
        this.regrasContribuicao.add(new RegraContribuicao(
                0.00, 1045.00, 0.075, 0.00));
        this.regrasContribuicao.add(new RegraContribuicao(
                1045.01,  2089.60, 0.09, 15.67));
        this.regrasContribuicao.add(new RegraContribuicao(
                2089.61, 3134.40, 0.12, 78.36));
        this.regrasContribuicao.add(new RegraContribuicao(
                3134.41,  6101.06, 0.14, 141.05));
        this.regrasContribuicao.add(new RegraContribuicao(
                6101.07,  null, 0.00, 713.10));
    }

    private static INSS getInstance() {
        if(instance == null){
            return new INSS();
        }
        return instance;
    }

    public Double getValorContribuicao(Double salarioBruto){
        RegraContribuicaoPredicates  regraContruicaoPredicates =  new RegraContribuicaoPredicates();
        RegraContribuicao regraContribuicao =
                regraContruicaoPredicates.getRegraContribuicao(this.regrasContribuicao, salarioBruto);
        return Calculo.getDeducao(regraContribuicao, salarioBruto);
    }

}
