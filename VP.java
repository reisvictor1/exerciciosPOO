
package vp;

/**
 * Este programa tem a finalidade de simular um jogo de poker, chamado VideoPoker.
 * O usuário recebe uma mão da classe JogaCartas, e pode mudar quais cartas ele quiser.
 * O jogo acaba quando os créditos acabam.
 * 
 * Victor Vieira Custodio Reis - 10734686
 * Matheus Lopes Rigato - 10260462
 * 
 * @author Victor Reis, Matheus Rigato
 */
public class VP {

   
    public static void main(String[] args) {
       int creditos = 200, valor = 0, saldo;
       String ent = "";
       int[] escolha = new int[5]; // Guardar as cartas 
       Pontos p = new Pontos();
       String s = "";
       JogaCartas mao = new JogaCartas(5);
      
       do{
           try{
               System.out.println("Digite algo para começar");
               ent = EntradaTeclado.leString();
           }catch(Exception e){
               System.out.println("Digite algo " + e);
           }
           
       }while(ent.equals(" ") == true);
       
       do{
            do{
                try{
                    System.out.println("Quanto você quer apostar?");
                    valor = EntradaTeclado.leInt();
               
                }catch(Exception e){
                    System.out.println("Não é um número ou está apostando mais do que você tem.");
                }
            }while(valor > creditos);
       
       
            creditos -= valor;
            
            mao.novaRodada();
         
            System.out.print(mao.toString());
       
            saldo = p.calculaValor(mao.getCartas(),valor);
            
       
            for(int j = 0; j < 2; j++){
           
          
                do{
                    try{
                        System.out.println("Deseja mudar as cartas?");
                        ent = EntradaTeclado.leString();
                        s = ent.toUpperCase();
                    }catch(Exception e){
                    System.out.println("Digite outra coisa");
                    }
                }while(ent.equals(""));        
        
                if(s.equals("S")){
        
                    do{
                        try{
                            System.out.println("Quais cartas você quer mudar?");
                            ent = EntradaTeclado.leString();
                        }catch(Exception e){
                            System.out.println("Digite um número");
                        }
                    }while(ent.equals(""));
                    int i;
                    for(i = 0; i < ent.length(); i++){
                        s = ent.substring(i, i+1);
                        escolha[i] = Integer.parseInt(s);
                    }
                    
                    
                    
                    mao.sorteiaCartas(escolha);
            
                }
    
                if(s.equals("N")){
                    break;
                }
        
                System.out.print(mao.toString());
       
                saldo = p.calculaValor(mao.getCartas(),valor);
        
            }
       
            creditos += saldo;
            System.out.println("Você tem "+creditos+ " creditos");
       
       }while(creditos > 0);
    }
}