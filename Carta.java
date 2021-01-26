package vp;
/**
 * Classe carta:
 * 
 * -sorteiaCarta(): Escolhe um número aleatorio entre  0 e 51
 * -getValor(): Retorna o valor da carta
 * -toString(): retorna uma string com o valor da carta 
 * 
 * @author Victor Reis, Matheus Rigato
 */

public class Carta {
	// valor = (num * 4) + naipe
	
	// naipe -> 0 = ♦ (diamond)
	//          1 = ♤ (spade)
	//          2 = ♥ (heart)
	//          3 = ♧ (club)
	
	// num -> 0 = J
	//        1 = Q
	//        2 = 2
	//        3 = 3
	//        4 = 4
	//        5 = 5
	//        6 = 6
	//        7 = 7
	//        8 = 8
	//        9 = 9
	//       10 = 10
	//       11 = K
	//       12 = A
	private int valor = 0; // range: 0 - 51
	private Random r = new Random();
	
	
	public int sorteiaCarta() {
		valor = r.getIntRand(52);
		return valor;
	}
	
        
        int getValor(){
            return valor;
        }
	
@Override

	public String toString() {
		int num = valor / 4;
		int naipe = valor % 4;
		String s = num + "";
		
		// casos em que a carta nao eh numero
		switch (num) {
			case 0:
				s = "J";
				break;
			case 1:
				s = "Q";
				break;
			case 11:
				s = "K";
				break;
			case 12:
				s = "A";
		}
		
		switch (naipe) {
			case 0:
				s += "♦";
				break;
			case 1:
				s += "♤";
				break;
			case 2:
				s += "♥";
				break;
			case 3:
				s += "♧";
		}
		
		return s;
	}

   
	
}