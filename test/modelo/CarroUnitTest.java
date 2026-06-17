package modelo;

import excecoes.QuantidadePassageiroInvalidoException;
import org.junit.jupiter.api.Test;
import taxas.TabelaTaxaVeiculoLeve;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarroUnitTest {

    @Test
    void shouldSucessOnObterCustoCombustivel() {
        final var quantidadePassageiros = 1;
        final var tabelaTaxa = new TabelaTaxaVeiculoLeve();
        final var distancia = 100D;

        var veiculo = new Carro(quantidadePassageiros, tabelaTaxa, distancia);

        assertEquals(0.4D, veiculo.obterCustoCombustivel());
        assertEquals(0.8D, veiculo.obterValorTransporte());
        assertEquals(120D, veiculo.obterValorTotal(), 0.1);
    }

    @Test
    void shouldQuantidadePassageiroInvalidoExceptionOnObterCustoCombustivel() {
        assertThrows(QuantidadePassageiroInvalidoException.class, () -> new Carro(0, new TabelaTaxaVeiculoLeve(), 5D));
        assertThrows(QuantidadePassageiroInvalidoException.class, () -> new Carro(5, new TabelaTaxaVeiculoLeve(), 5D));
    }
}