/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;
import Model.*;
import Persistencia.Serializador;
import View.*;
import Control.ControladorGeral;
import java.util.concurrent.TimeUnit;
import Persistencia.Serializador;

/**
 *
 * @author meucomputador
 */
public class Trabalho {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        /*ControladorGeral ctrl = ControladorGeral.getInstance();
        ctrl.adicionaLivro(new Livro("Harry"));
        ctrl.adicionaLivro(new Livro("Potter"));
        TelaUsuarioLogado tela = new TelaUsuarioLogado();
        tela.setVisible(true);
        ctrl.adicionaLivro(new Livro("Funfou"));
        tela = new TelaUsuarioLogado();
        tela.setVisible(true);
        */
        
        ControladorGeral.getInstance().inicializaTelas();
        
    }
    
}
