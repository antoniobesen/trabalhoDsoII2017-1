/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Autenticacao;

/**
 *
 * @author meucomputador
 */
public class Usuario {
    
    private String nome;
    private String senha;
    private boolean gerente;

    public Usuario(String nome, String senha, boolean gerente) {
        this.nome = nome;
        this.senha = senha;
        this.gerente = gerente;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isGerente() {
        return gerente;
    }
    
    
}
