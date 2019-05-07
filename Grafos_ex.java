/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos_ex;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author USUARIOS+10734686
 */
public class Grafos_ex extends Grafo{

    
    public static void main(String[] args) {
     
      
        Scanner reader;
        reader = new Scanner(System.in);
        String filename = reader.toString();
        Grafo cidades = null;
        
        try{
            cidades = new Grafo(filename);
        }
        catch(Exception e){
            System.out.println("Deu erro ao abrir o arquivo");
        }
        
        if(cidades != null){
             cidades.criaGrafo();
        }
       
        
    }
    
}
