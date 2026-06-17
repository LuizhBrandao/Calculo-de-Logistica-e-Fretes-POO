// Caminhao.java
package modelo;

import excecoes.QuantidadeCargaInvalidaException;
import taxas.TabelaTaxa;
import java.util.logging.Logger;

public class Caminhao extends Veiculo {
    private final double carga;
    private static final Logger logger = Logger.getLogger(Caminhao.class.getName());

    public Caminhao(double carga, TabelaTaxa tabelaTaxa, double distancia) {
        super(distancia, tabelaTaxa);
        if (carga < 1 || carga > 300) {
            logger.warning("Falha na regra de negócio: Caminhão com carga fora do limite (1 a 300kg). Valor recebido: " + carga);
            throw new QuantidadeCargaInvalidaException("O caminhão deve ter carga entre 1 e 300 quilos.");
        }
        this.carga = carga;
    }

    @Override
    public Double obterCustoCombustivel() {
        double custo = tabelaTaxa.obterPorDistanciaEmQuilometros(distancia);
        return distancia < 100 ? custo + 0.3 : custo;
    }

    @Override
    public Double obterValorTransporte() {
        double custo = tabelaTaxa.obterPorPesoEmQuilo(carga);
        return carga < 50 ? custo + 0.2 : custo;
    }
}