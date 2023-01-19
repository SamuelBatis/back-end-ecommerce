package com.store.ecommerce.domain.product;

public record DadosCadastroProduto(
    String productName,
    String productDescription,
    Double productPrice,
    Long quantity
) {
}
