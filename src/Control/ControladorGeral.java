/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.*;
import java.util.List;
import View.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import Persistencia.*;
import java.util.ArrayList;
import Autenticacao.Autenticador;
import Autenticacao.Usuario;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author meucomputador
 */
public class ControladorGeral {
    private static ControladorGeral instance = null;

    private Biblioteca biblioteca;
    private Autenticador a;
    private Serializador s;
    private TelaLogin telaL = null;
    private TelaRegistrarLivro telaRL = null;
    private TelaUsuarioLogado telaUL = null;
    private TelaRegistroUsuario telaRU =  null;
    private TelaDevolveLivro telaDL = null;
    private MostradorDeMensagens mostrador;
    
    private ControladorGeral() {
        a = new Autenticador();
        biblioteca = new Biblioteca();
        mostrador = new MostradorDeMensagens();
        s = new Serializador();
    }
    public static ControladorGeral getInstance(){
        if(instance == null) {
            instance = new ControladorGeral();
        }
        return instance;
    }
    
    public void inicializaTelas() {
        telaL = new TelaLogin();
        telaRL = new TelaRegistrarLivro();
        telaUL = new TelaUsuarioLogado();
        telaRU = new TelaRegistroUsuario();
        telaDL = new TelaDevolveLivro();
        telaUL.populaTabela();
        telaL.setVisible(true);
        
    }
    
    public void adicionaLivro(Livro l) {
        biblioteca.adicionaLivro(l);
        s.persisteLivros(biblioteca);
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) telaUL.getjTable().getModel();
        model.addRow(new Object[] {l.getNome(), "disponivel"});
        
    }
    
    public void removeLivro(int index) {
        if(biblioteca.getLivros().get(index).isDisponivel()){
            biblioteca.removeLivro(index);
            s.persisteLivros(biblioteca);
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) telaUL.getjTable().getModel();
            model.removeRow(index);
        } else
            mostrador.mostraMsgDelecaoLivroInd(telaUL);
        
    }
    
    public List<Livro> getLivros() {
        Biblioteca b = s.recuperaLivros();
        if(b!=null)
            biblioteca = b;
        return biblioteca.getLivros();
    }

    public void vaiParaRegistrarLivro() {
        telaRL.setVisible(true);
    }

    public void vaiParaTelaUsuarioLogado() {
        telaUL.setVisible(true);
    }
    
    public void vaiParaTelaLogin() {
        telaL.setVisible(true);
    }

    public void emprestaLivro(int index, String nome, String telefone, String cpf,int dia,int mes, int ano) {
        Livro l = biblioteca.getLivros().get(index);
        if(l.isDisponivel()) {
            Data data = new Data(dia,mes,ano);
            l.setUsuario(new UsuarioDaBiblioteca(nome,cpf,telefone,data));
            l.setDisponivel(false);
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) telaUL.getjTable().getModel();
            s.persisteLivros(biblioteca);
            telaUL.atualizaTabela();
        } else {
            mostrador.mostraMsgLivroIndisponivel(telaUL);
        }
    }
    
    public void vaiParaTelaRegistroUsuario(int index) {
        Livro l = biblioteca.getLivros().get(index);
        if(l.isDisponivel())
            telaRU.setVisible(true);
        else
            mostrador.mostraMsgLivroIndisponivel(telaUL);
    }

    public void registraAluguel(String nome, String telefone, String cpf,int dia, int mes, int ano) {
        telaUL.registraAluguel(nome, telefone, cpf, dia, mes, ano);
    }

    public void devolveLivro(int index, int dia, int mes, int ano) {
        Calendar dataDevolucao = new GregorianCalendar(ano,mes-1,dia);
        Livro l = biblioteca.getLivros().get(index);
        if(!l.isDisponivel()) {
            int multa = l.getUsuario().getData().getMulta(dataDevolucao);
            if(multa > 0)
                mostrador.mostraMsgMulta(telaUL, multa);
            l.setUsuario(null);
            l.setDisponivel(true);
            s.persisteLivros(biblioteca);
            telaUL.atualizaTabela();
        }
        else {
            mostrador.mostraMsgLivroDisponivel(telaUL);
        }
    }
    

    public void getInfo(int index) {
        Livro l = biblioteca.getLivros().get(index);
        if(!l.isDisponivel()) {
            mostrador.mostraInfoUsuario(telaUL,l.getUsuario());
        } else {
            mostrador.mostraMsgSemInfoLivroDisponivel(telaUL);
        }
    }

    public void autenticaUsuario(String nome, String senha) {
        Usuario usuario = a.autentica(nome, senha);
        if(usuario == null)
            mostrador.mostraMensagemUsuarioInvalido(telaL);
        else {
            if(usuario.isGerente()) {
                telaUL.getjButton1().setVisible(true);
                telaUL.getjButton2().setVisible(true);
                telaUL.getjButton3().setVisible(false);
                telaUL.getjButton4().setVisible(false);
                telaL.setVisible(false);
                vaiParaTelaUsuarioLogado();
            } else {
                telaUL.getjButton1().setVisible(false);
                telaUL.getjButton2().setVisible(false);
                telaUL.getjButton3().setVisible(true);
                telaUL.getjButton4().setVisible(true);
                telaL.setVisible(false);
                vaiParaTelaUsuarioLogado();
            }
        }
            
    }

    public void vaiParaTelaDevolveLivro(int index) {
        Livro l = biblioteca.getLivros().get(index);
        if(!l.isDisponivel()) {
            telaDL.setVisible(true);
        }
        else {
            mostrador.mostraMsgLivroDisponivel(telaUL);
        }
        
    }

    public void registraDevolucao(int dia, int mes, int ano) {
        int index = telaUL.getIndex();
        devolveLivro(index,dia,mes,ano);
    }
    
    
    
}
