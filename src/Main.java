import modelo.Bicicleta;
import modelo.Caminhao;
import modelo.Carro;
import modelo.Veiculo;
import taxas.TabelaTaxaVeiculoLeve;
import taxas.TabelaTaxaVeiculoPesado;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criando a frota
        Veiculo carro = obterCarro();
        Veiculo caminhao = obterCaminhao();
        Veiculo bicicleta = obterBicicleta();

        // Adicionando na lista (Polimorfismo em ação)
        List<Veiculo> veiculos = new ArrayList<>();
        veiculos.add(carro);
        veiculos.add(caminhao);
        veiculos.add(bicicleta);

        // Calculando o valor total da frota
        Double precoTotal = 0D;
        for (Veiculo veiculo : veiculos) {
            precoTotal += veiculo.obterValorTotal();
        }

        System.out.println("Preço total da frota: R$ " + precoTotal);
    }

    // Métodos auxiliares para instanciar os veículos passando as taxas e regras
    private static Veiculo obterCarro() {
        // Carro: 3 passageiros, taxa leve, 50km de distância
        return new Carro(3, new TabelaTaxaVeiculoLeve(), 50);
    }

    private static Veiculo obterCaminhao() {
        // Caminhão: 150kg de carga, taxa pesada, 200km de distância
        return new Caminhao(150, new TabelaTaxaVeiculoPesado(), 200);
    }

    private static Veiculo obterBicicleta() {
        // Bicicleta: 1 passageiro, taxa leve, 10km de distância
        return new Bicicleta(1, new TabelaTaxaVeiculoLeve(), 10);
    }
}