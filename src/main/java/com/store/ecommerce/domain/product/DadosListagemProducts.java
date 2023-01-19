package com.store.ecommerce.domain.product;

public record DadosListagemProducts(Long id, String productName, String productDescription, Double productPrice, Long quantity) {
  public DadosListagemProducts(Product product) {
   this(product.getId(), product.getProductName(), product.getProductDescription(), product.getProductPrice(), product.getQuantity());
  }
}
