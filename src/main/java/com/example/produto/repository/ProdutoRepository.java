package com.example.produto.repository;

import com.example.produto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Não é necessário implementar deleteAll, pois é fornecido pelo Spring Data JPA
}
