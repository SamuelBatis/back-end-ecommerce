package com.store.ecommerce.controller;

import com.store.ecommerce.domain.product.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/products")
public class ProductsController {

  @Autowired
  private ProductRepository repository;

  @PostMapping
  @Transactional
  public ResponseEntity cadastrarProduto(@RequestBody DadosCadastroProduto dados, UriComponentsBuilder uriBuilder) {
    var product = new Product(dados);
    repository.save(product);
    var uri = uriBuilder.path("/products/{id}").buildAndExpand(product).toUri();
    return ResponseEntity.created(uri).body(new DadosDetalhamentoProduct(product));
  }

  @GetMapping
  public ResponseEntity<Page<DadosListagemProducts>> listarProdutos(@PageableDefault(size = 10) Pageable paginacao) {
    var page = repository.findAll(paginacao).map(DadosListagemProducts::new);
    return ResponseEntity.ok(page);
  }

  @PutMapping
  @Transactional
  public ResponseEntity atualizar(@RequestBody DadosAtualizacaoProduto dados) {
    var product = repository.getReferenceById(dados.id());
    product.atualizarInformacoes(dados);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity excluir(@PathVariable Long id) {
    repository.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity detalhar(@PathVariable Long id) {
    var medico = repository.getReferenceById(id);
    return ResponseEntity.ok(new DadosDetalhamentoProduct(medico));
  }

}
