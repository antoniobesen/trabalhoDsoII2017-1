/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.UsuarioDaBiblioteca;
import javax.swing.JOptionPane;

/**
 *
 * @author meucomputador
 */
public class MostradorDeMensagens {
    
    public void mostraMsgLivroDisponivel(TelaUsuarioLogado telaUL) {
        JOptionPane.showMessageDialog(telaUL, "Livro ja disponivel");
    }
    
    public void mostraMsgLivroIndisponivel(TelaUsuarioLogado telaUL) {
        JOptionPane.showMessageDialog(telaUL, "Livro indisponivel");
    }
    
    public void mostraMsgDelecaoLivroInd(TelaUsuarioLogado telaUL) {
        JOptionPane.showMessageDialog(telaUL, "Não é possível remover livros indisponiveis");
    }

    public void mostraMsgSemInfoLivroDisponivel(TelaUsuarioLogado telaUL) {
        JOptionPane.showMessageDialog(telaUL, "Não é possível obter info de livros disponiveis");
    }

    public void mostraInfoUsuario(TelaUsuarioLogado telaUL, UsuarioDaBiblioteca usuario) {
        JOptionPane.showMessageDialog(telaUL, "Pessoa que locou: "
                + usuario.getNome()+"\n" + "CPF: "+usuario.getCpf()+"\n" +"Data de emprestimo: " + usuario.getData().getDataAluguel() +"\n"
                + "Data maxima de devolucao sem multa " + usuario.getData().getDataDevolucao()
                , "Informações do usuário", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostraMensagemUsuarioInvalido(TelaLogin telaL) {
        JOptionPane.showMessageDialog(telaL, "Usuario ou senha invalida");
    }

    public void mostraMsgMulta(TelaUsuarioLogado telaUL, int multa) {
        JOptionPane.showMessageDialog(telaUL, "Multa: "+multa+" reais");
    }
}
