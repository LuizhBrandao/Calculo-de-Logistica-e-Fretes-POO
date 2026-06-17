package modelo;

import excecoes.QuantidadeCargaInvalidaException;
import org.junit.jupiter.api.Test;
import taxas.TabelaTaxaVeiculoPesado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CaminhaoUnitTest {

    @Test
    void shouldSucessOnObterCustoCombustivel() {
        final var quantidadeQuiloDaCarga = 50D;
        final var tabelaTaxa = new TabelaTaxaVeiculoPesado();
        final var distancia = 100D;

        var veiculo = new Caminhao(quantidadeQuiloDaCarga, tabelaTaxa, distancia);
        assertEquals(0.2D, veiculo.obterCustoCombustivel());
        assertEquals(0.2D, veiculo.obterValorTransporte());
        assertEquals(40D, veiculo.obterValorTotal());
    }

    @Test
    void shouldSucessWithMoreTaxOnObterCustoCombustivel() {
        final var quantidadeQuiloDaCarga = 40D;
        final var tabelaTaxa = new TabelaTaxaVeiculoPesado();
        final var distancia = 90D;

        var veiculo =
                new Caminhao(quantidadeQuiloDaCarga, tabelaTaxa, distancia);
        assertEquals(0.5D, veiculo.obterCustoCombustivel());
        assertEquals(0.4D, veiculo.obterValorTransporte(), 0.1);
        assertEquals(81D, veiculo.obterValorTotal());
    }

    @Test
    void shouldQuantidadePassageiroInvalidoExceptionOnObterCustoCombustivel() {
        assertThrows(QuantidadeCargaInvalidaException.class, () -> new Caminhao(-1D, new TabelaTaxaVeiculoPesado(), 100D));
    }
}