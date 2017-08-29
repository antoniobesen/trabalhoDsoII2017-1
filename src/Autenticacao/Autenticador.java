/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Autenticacao;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author meucomputador
 */
public class Autenticador implements AutenticaUsuario {

    private ArrayList<Usuario> usuarios;
    
    public Autenticador() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("gerente","123",true));
        usuarios.add(new Usuario("funcionario","321",false));
    }

    public Usuario autentica(String nome, String senha) {
        for(Usuario usuario : usuarios) {
            if(usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }
    
    
}
