package taxas;

public class TabelaTaxaVeiculoLeve implements TabelaTaxa {
    @Override
    public Double obterPorPassageiro(int quantidade) {
        if(quantidade >= 0 && quantidade < 10) return 0.8;
        else if(quantidade >= 10 && quantidade < 15) return 0.6;
        return 0.4;
    }

    @Override
    public Double obterPorDistanciaEmQuilometros(double km) {
        if(km >= 0 && km < 10) return 0.8;
        else if(km >= 10 && km < 15) return 0.6;
        return 0.4;
    }

    @Override
    public Double obterPorPesoEmQuilo(double kg) {
        if(kg >= 0 && kg < 10) return 0.8;
        else if(kg >= 10 && kg < 15) return 0.6;
        return 0.4;
    }
}