// Bicicleta.java
package modelo;

import excecoes.QuantidadePassageiroInvalidoException;
import taxas.TabelaTaxa;
import java.util.logging.Logger;

public class Bicicleta extends Veiculo {
    private final int passageiros;
    private static final Logger logger = Logger.getLogger(Bicicleta.class.getName());

    public Bicicleta(int passageiros, TabelaTaxa tabelaTaxa, double distancia) {
        super(distancia, tabelaTaxa);
        if (passageiros != 1) {
            logger.warning("Falha na regra de negócio: Bicicleta com passageiros diferente de 1. Valor recebido: " + passageiros);
            throw new QuantidadePassageiroInvalidoException("A bicicleta deve ter exatamente 1 passageiro.");
        }
        this.passageiros = passageiros;
    }

    @Override
    public Double obterCustoCombustivel() {
        return 0D;
    }

    @Override
    public Double obterValorTransporte() {
        return tabelaTaxa.obterPorPassageiro(passageiros) - 0.2;
    }
}