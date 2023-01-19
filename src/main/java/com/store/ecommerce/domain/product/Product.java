package com.store.ecommerce.domain.product;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "product")
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String productName;
  private String productDescription;
  private Double productPrice;
  private Long quantity;

  public Product(DadosCadastroProduto dados) {
    this.productName = dados.productName();
    this.productDescription = dados.productDescription();
    this.productPrice = dados.productPrice();
    this.quantity = dados.quantity();
  }

  public void atualizarInformacoes(DadosAtualizacaoProduto dados) {
    if (dados.productName() != null) {
      this.productName = dados.productName();
    }
    if (dados.productDescription() != null) {
      this.productDescription = dados.productDescription();
    }
    if (dados.productPrice() != null) {
      this.productPrice = dados.productPrice();
    }
    if (dados.productPrice() != null) {
      this.quantity = dados.quantity();
    }


  }

}
