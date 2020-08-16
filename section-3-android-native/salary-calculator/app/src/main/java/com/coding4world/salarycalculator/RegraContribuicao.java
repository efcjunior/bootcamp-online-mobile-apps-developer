package com.coding4world.salarycalculator;

public class RegraContribuicao {

    private Double salarioMinimo;
    private Double salarioMaximo;
    private Double aliquota;
    private Double deducao;

    public RegraContribuicao(Double salarioMinimo, Double salarioMaximo, Double aliquota, Double deducao){
        this.salarioMinimo = salarioMinimo;
        this.salarioMaximo = salarioMaximo;
        this.aliquota = aliquota;
        this.deducao = deducao;
    }

    public Double getSalarioMinimo() {
        return salarioMinimo;
    }

    public Double getSalarioMaximo() {
        return salarioMaximo;
    }

    public Double getAliquota() {
        return aliquota;
    }

    public Double getDeducao() {
        return deducao;
    }
}