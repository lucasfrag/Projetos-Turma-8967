package com.senacead.biblioteca.model.service;

import com.senacead.biblioteca.model.entity.LivroEntity;
import com.senacead.biblioteca.model.repository.LivroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
    @Autowired
    LivroRepository livroJPA;
    
    // INSERT = Adicionar registro no banco
    public LivroEntity inserir(LivroEntity livro) {
        livroJPA.save(livro);
        return livro;
    }
    
    // SELECT * = Buscar todos os registros
    public List<LivroEntity> listarTodos() {
        return livroJPA.findAll();
    }
    
    // SELECT = Buscar um registro especifico
    public LivroEntity getPorId(Integer id) {
        return livroJPA.findById(id).orElse(null);
    }
    
    // UPDATE = Atualizar um registro existente
    public LivroEntity atualizar(Integer id, LivroEntity livroNovo) {
        LivroEntity livroAtual = getPorId(id);
        
        livroAtual.setNome(livroNovo.getNome());
        livroAtual.setAutor(livroNovo.getAutor());
        livroAtual.setLido(livroNovo.isLido());
        
        livroJPA.save(livroAtual);
        return livroAtual;
    }
    
    // DELETE = Remover um registro existente
    public LivroEntity remover(Integer id) {
        LivroEntity livro = getPorId(id);
        livroJPA.deleteById(livro.getId());
        return livro;
    }
}
