package com.example.produto.model;


import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Data  // Lombok gerando getters, setters, toString, etc.
@NoArgsConstructor  // Lombok gerando o construtor sem argumentos
@AllArgsConstructor // Lombok gerando o construtor com todos os argumentos
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String descricao;
    private double preco;

    @ManyToOne  
    @JoinColumn(name = "categoria_id")  
    private Categoria categoria;

}

