package com.senacead.biblioteca.model;

import com.senacead.biblioteca.model.entity.LivroEntity;
import java.util.ArrayList;

// Classe criada para guardar informações na memória
// Como estamos gravando os dados no banco de dados, ela não é mais utilizada

public class ListaLivro {
    private static ArrayList<LivroEntity> lista = new ArrayList<LivroEntity>();
    
    
    public static void adicionar(LivroEntity livro) {
        lista.add(livro);
    }
    
    public static ArrayList<LivroEntity> getLista() {
        return lista;
    }
}
