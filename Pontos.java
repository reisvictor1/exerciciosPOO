/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vp;

/**
 * Classe Pontos:
 * 
 * Método calculaValor: verifica qual é o caso que a mão do jogador pertence, recebe o parâmetro int[] que é o array de cartas
 * 
 * Método casos1 : Verifica se a mão faz parte dos casos  de 2 pares, uma trinca, uma quadra ou um full hand; recebe o array de frequência de cartas
 *
 * Método casos2: Verifica se a mão faz parte dos casos de straight, flush, straight flush ou rotal straight flush; recebe os arrays de frequencia de cartas 
 * e de naipes.
 * 
 * @author Victor Reis, Matheus Rigato
 */
public class Pontos {
    // Resolve os casos de flush, straight, royal straight flush e straight flush
    private int casos2(int[] valor, int[] naipes){
        
        int naipe = 0, insert = 0;
        int controle = 0;
        
        //Verifica se tem naipes iguais
        for(int i = 0; i < naipes.length; i ++){
            
            if(insert == 0){
                naipe = naipes[i];
                insert++;
            }
            
            if(naipes[i] != naipe){
                naipe = -1;
                break;
            }
        }
        
        int j = 0;
        
        // Entra nos casos para ver qual será o caso
        for(int i = 0; i < valor.length; i++){
           
            if(valor[i] != 0){
                
                // Se não tiver naipe igual, verifica se é straight
                if(naipe < 0){
                    
                    controle = 3;
                    
                    if(j < 0 || j != i-1){
                        controle = 0;
                        break;
                   }
                       
                    j = i;
                }
                else{
                    //Se tiver naipes iguais, entra nos 3 casos restantes
                    // Verifica os casos,´com o padrão sendo um straight flush
                    controle = 7;
                    
                    // Verifica se é o royal straight flush
                    if(i == 10 || i == 0 || i == 1 || i == 11 || i == 12){
                        controle = 8;
                    }
                    // Se não for straight, com certeza será flush
                    if(j < 0 || j != i -1){
                        controle = 4;
                        break;
                    }
                    
                    j = i;
                }
                
            }
                
            
            
        }
        
        return controle;
        
    }
    // Resove os casos de 2 pares, trinca, full hand e quadra
    private int casos1(int[] freq){
        
        int controle = 0;
        int j = 0;
        
        for(int i = 0; i < freq.length; i++){
            
            
    
            if(freq[i] == 2)
                j++;
            
            if(freq[i] == 3)
                j+=4;
            
            if(freq[i] == 4)
                j+=4;
        }
        
        switch(j){
          //Caso j seja 2, é par  
            case 2 :
                controle = 1;
                break;
          //Caso j seja 3, é uma trinca   
            case 3:
                controle = 2;
                break;
            
            //Caso j seja 4, é uma quadra    
            case 4:
                controle = 6;
                break;
            //Caso j seja 5, é um full hand
            case 5:
                controle = 5;
        }
        
        
        
        return controle;
        
    }
    
    
    
    
 
    int calculaValor(Carta[] cartas, int recebido){
        
        int[] freq_valor = new int[13]; 
        int[] freq_naipe = new int[4];
        int valor = recebido;
        
 
        for(int i = 0; i < cartas.length; i++){
            
            valor = cartas[i].getValor();
            
            freq_valor[valor/4]++;
            freq_naipe[valor%4]++;
            
        }
        
        int controle, j = 0;
        
        controle = casos1(freq_valor);
        
        if(controle == 0){
            
            controle = casos2(freq_valor,freq_naipe);
        }
        
        
        
        switch(controle){
            
            case 0:
                valor = 0;
                break;
            case 2:
                valor*= 2;
                break;
            case 3:
                valor *= 5;
                break;
            case 4:
                valor*= 10;
                break;
            case 5:
                valor*= 20;
                break;
            case 6:
                valor *=50;
                break;
            case 7:
                valor*= 100;
                break;
            case 8:
                valor*= 200;
        }
        
        return valor;
        
    }
    
}
