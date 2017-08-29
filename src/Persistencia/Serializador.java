/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Model.Biblioteca;
import Model.Livro;
import java.io.*;

public class Serializador implements PersisteObjeto{
    
   
    public void persisteLivros(Biblioteca b) {
         try {
         FileOutputStream fileOut =
         new FileOutputStream("livros.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(b);
         out.close();
         fileOut.close();
      }catch(IOException i) {
         i.printStackTrace();
      }
    }
    
    public Biblioteca recuperaLivros() {
        Biblioteca b = null;
        try {
         FileInputStream fileIn = new FileInputStream("livros.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         b = (Biblioteca) in.readObject();
         in.close();
         fileIn.close();
         return b;
      } catch(IOException i) {
         return b;
    }
        catch(ClassNotFoundException c) {
         System.out.println("class not found");
         c.printStackTrace();
      }
       
        return b;
    }
}
