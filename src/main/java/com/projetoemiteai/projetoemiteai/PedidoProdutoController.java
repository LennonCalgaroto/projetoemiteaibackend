package com.projetoemiteai.projetoemiteai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/pedido-produto")
public class PedidoProdutoController {

    private final PedidoProdutoService pedidoProdutoService;

    @Autowired
    public PedidoProdutoController(PedidoProdutoService pedidoProdutoService) {
        this.pedidoProdutoService = pedidoProdutoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarPedidoProduto(@RequestParam Long pedidoId,
                                                     @RequestParam Long produtoId,
                                                     @RequestParam Integer quantidade,
                                                     @RequestParam BigDecimal valorTotalPedido) {
        try {
            pedidoProdutoService.criarPedidoProduto(pedidoId, produtoId, quantidade, valorTotalPedido);
            return new ResponseEntity<>("PedidoProduto criado com sucesso.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao criar PedidoProduto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

