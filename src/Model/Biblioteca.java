/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author meucomputador
 */
public class Biblioteca implements Serializable {
    
    private List<Livro> livros = new ArrayList<>();
    
    public Biblioteca() {
    }
    
    public void adicionaLivro(Livro l) {
        livros.add(l);
    }
    
    public void removeLivro(int index) {
        livros.remove(index);
    }
    
    public List<Livro> getLivros() {
        return livros;
    }
            
    }
