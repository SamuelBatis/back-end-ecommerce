package com.store.ecommerce.domain.product;

public record DadosDetalhamentoProduct(
    Long id,
    String productName,
    String productDescription,
    Double productPrice,
    Long quantity
) {
  public DadosDetalhamentoProduct(Product product) {
    this(product.getId(), product.getProductName(), product.getProductDescription(), product.getProductPrice(), product.getQuantity());
  }
}
