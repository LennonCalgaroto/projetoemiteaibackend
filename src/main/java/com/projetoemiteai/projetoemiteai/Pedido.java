package com.projetoemiteai.projetoemiteai;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_sequencial", nullable = false)
    private Integer numeroSequencial;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;


}

