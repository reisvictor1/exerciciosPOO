package grafos_ex;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Grafo {

    File entry;
    Map<String,HashMap<String, Integer>> vert; 
    Scanner reader;
    public Grafo(String filename) throws FileNotFoundException {
        
        entry  = new File(filename);
        reader = new Scanner(entry);
        vert = new HashMap<String, HashMap<String,Integer>>();
     
        
    }
    
    
    void caminhoMinimo(){
     
        
        
    }
    
    
    void criarGrafo(){
        
        String nome_cidade;
        HashMap<String, Integer> adj;
        
        while(reader.hasNext()){
            String adj_cidade;
            int dist;
            nome_cidade = reader.next();
            
            adj = new HashMap<String,Integer>();
            
            while(!reader.hasNextInt()){
                adj_cidade = reader.next();
                dist = reader.nextInt();
                
                adj.put(adj_cidade,dist);
                
            }
            
            vert.put(nome_cidade, adj);
           
        }
        
    }
    
    void imprimirGrafo(){
       
        
        
    }
    
   
}
