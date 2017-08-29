/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Model.Biblioteca;
import Model.Livro;

/**
 *
 * @author meucomputador
 */
public interface PersisteObjeto {
    
    public void persisteLivros(Biblioteca b);
    public Object recuperaLivros() throws java.io.FileNotFoundException;
}
