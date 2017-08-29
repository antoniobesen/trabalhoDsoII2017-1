/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

public class Livro implements Serializable {
    
    private String nome;
    private String id;
    private String edicao;
    private boolean disponivel;
    private UsuarioDaBiblioteca usuario;
    
    public Livro(String nome, String id, String edicao) {
        this.nome = nome;
        disponivel = true;
        usuario = null;
    }
    
    public String getNome() {
        return this.nome;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setUsuario(UsuarioDaBiblioteca usuario) {
        this.usuario = usuario;
    }

    public UsuarioDaBiblioteca getUsuario() {
        return usuario;
    }
    
    public void setDisponivel(boolean b) {
        this.disponivel = b;
    }
}
