package com.store.ecommerce.domain.product;

public record DadosAtualizacaoProduto(
    Long id,
    String productName,
    String productDescription,
    Double productPrice,
    Long quantity
) {
}
