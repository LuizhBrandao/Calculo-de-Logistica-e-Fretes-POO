// Carro.java
package modelo;

import excecoes.QuantidadePassageiroInvalidoException;
import taxas.TabelaTaxa;
import java.util.logging.Logger;

public class Carro extends Veiculo {
    private final int passageiros;
    private static final Logger logger = Logger.getLogger(Carro.class.getName());

    public Carro(int passageiros, TabelaTaxa tabelaTaxa, double distancia) {
        super(distancia, tabelaTaxa);
        if (passageiros < 1 || passageiros > 4) {
            logger.warning("Falha na regra de negócio: Carro com passageiros fora do limite (1 a 4). Valor recebido: " + passageiros);
            throw new QuantidadePassageiroInvalidoException("O carro deve ter entre 1 e 4 passageiros.");
        }
        this.passageiros = passageiros;
    }

    @Override
    public Double obterCustoCombustivel() {
        return tabelaTaxa.obterPorDistanciaEmQuilometros(distancia);
    }

    @Override
    public Double obterValorTransporte() {
        return tabelaTaxa.obterPorPassageiro(passageiros);
    }
}