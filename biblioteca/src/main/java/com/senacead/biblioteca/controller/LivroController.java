package com.senacead.biblioteca.controller;

import com.senacead.biblioteca.model.entity.LivroEntity;
import com.senacead.biblioteca.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LivroController {
    
    @GetMapping("/") // Defini a URL Quando acessar localhost:8080/teste
    public String index(){
        return "index"; // Aponta qual arquivo HTML vai ser chamado
    }
    
    @GetMapping("/lista")
    public String lista(Model model) {        
        model.addAttribute("livros", ListaLivro.getLista());
        return "lista";
    }
    
    @GetMapping("/cadastro")
    public String exibirFormulario(Model model) {
        model.addAttribute("livro", new LivroEntity());
        return "cadastro";
    }
    
    @PostMapping("/cadastro")
    public String processarFormulario(@ModelAttribute LivroEntity livro, Model model) {
        livro.setId(ListaLivro.getLista().size() + 1);
        livro.setLido(false);
        ListaLivro.adicionar(livro);
        model.addAttribute("livro", livro);
        
        return "cadastro-sucesso";
    }
}
