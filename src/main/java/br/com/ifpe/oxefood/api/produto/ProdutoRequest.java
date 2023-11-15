package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequest {

    private Long idCategoria;

    private String titulo;

    private int codigoProduto;

    private String descricao;

    private int valorUnitario;

    private double tempMin;

    public Produto build() {
        return Produto.builder()
                .titulo(titulo)
                .codigoProduto(codigoProduto)
                .descricao(descricao)
                .valorUnitario(valorUnitario)
                .tempMin(tempMin)
                .build();

    }

}