// Veiculo.java
package modelo;

import excecoes.DistanciaInvalidaException;
import taxas.TabelaTaxa;
import java.util.logging.Logger;

public abstract class Veiculo {
    protected double distancia;
    protected TabelaTaxa tabelaTaxa;
    private static final Logger logger = Logger.getLogger(Veiculo.class.getName());

    public Veiculo(double distancia, TabelaTaxa tabelaTaxa) {
        if (distancia < 1) {
            logger.warning("Tentativa de criar veículo com distância menor que 1km: " + distancia);
            throw new DistanciaInvalidaException("A distância deve ser igual ou maior que 1 quilômetro.");
        }
        this.distancia = distancia;
        this.tabelaTaxa = tabelaTaxa;
    }

    // Métodos que cada veículo deverá implementar com suas próprias regras (Polimorfismo)
    public abstract Double obterCustoCombustivel();
    public abstract Double obterValorTransporte();

    // Regra genérica para todos os veículos (Template Method)
    public Double obterValorTotal() {
        return (obterCustoCombustivel() + obterValorTransporte()) * distancia;
    }
}