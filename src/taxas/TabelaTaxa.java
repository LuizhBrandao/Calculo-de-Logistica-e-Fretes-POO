// TabelaTaxa.java
package taxas;

public interface TabelaTaxa {
    Double obterPorPassageiro(int quantidade);
    Double obterPorDistanciaEmQuilometros(double km);
    Double obterPorPesoEmQuilo(double kg);
}