/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author meucomputador
 */
public class UsuarioDaBiblioteca implements Serializable {
    
    private String nome;
    private String cpf;
    private String telefone;
    private Data dataAluguel;

    public UsuarioDaBiblioteca(String nome, String cpf, String telefone, Data data) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataAluguel = data;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public Data getData() {
        return dataAluguel;
    }
    
    
    
}
