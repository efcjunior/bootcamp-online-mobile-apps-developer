package com.coding4world.salarycalculator;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class RegraContribuicaoPredicates {

    private Predicate<RegraContribuicao> entreFaixaSalarial(final Double salarioBruto){
        return r -> r.getSalarioMaximo() != null &&
                salarioBruto >= r.getSalarioMinimo() &&
                salarioBruto <= r.getSalarioMaximo();
    }

    private Predicate<RegraContribuicao> isContribuicaoMaxima(final Double salarioBruto){
        return r -> salarioBruto >= r.getSalarioMinimo() &&  r.getSalarioMaximo() == null;
    }


    private Optional<RegraContribuicao> getRegraContribuicao(
            List<RegraContribuicao> regrasContribuicao, Predicate<RegraContribuicao> predicate){
        return regrasContribuicao.stream().filter(predicate).findFirst();
    }

    public RegraContribuicao getRegraContribuicao(List<RegraContribuicao> regrasContribuicao, Double salarioBruto){
        return this.getRegraContribuicao(regrasContribuicao, this.entreFaixaSalarial(salarioBruto)).orElse(
                this.getRegraContribuicao(regrasContribuicao, this.isContribuicaoMaxima(salarioBruto)).orElse(
                        new RegraContribuicao(null,null,null,null)
                )
        );
    }
}