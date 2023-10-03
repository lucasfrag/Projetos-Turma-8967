package com.senacead.biblioteca.controller;

import com.senacead.biblioteca.model.entity.LivroEntity;
import com.senacead.biblioteca.model.service.LivroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/livros")
public class LivroAPI {
    @Autowired
    LivroService jpa;

    @GetMapping // GET = "Pega" uma informação
    public List<LivroEntity> buscarTudo() {
        return jpa.listarTodos();
    }

    @GetMapping("/{id}") // GET = "Pega" uma informação
    public LivroEntity buscarPorId(@PathVariable int id) {
        return jpa.getPorId(id);
    }

    @PostMapping // POST = "insere" um novo registro
    public LivroEntity adicionar(@RequestBody LivroEntity livro) {
        //livro.setId(ListaLivro.getLista().size() + 1);
        //ListaLivro.adicionar(livro);
        jpa.inserir(livro);
        return livro;
    }

    @PutMapping("/{id}") // PUT = "atualiza" um registro existente
    public LivroEntity atualizar(@PathVariable int id, @RequestBody LivroEntity livroAtualizado) {
        return jpa.atualizar(id, livroAtualizado);
    }

    @DeleteMapping("/{id}") // DELETE = remover registro
    public LivroEntity remover(@PathVariable int id) {
        return jpa.remover(id);
    }

}
