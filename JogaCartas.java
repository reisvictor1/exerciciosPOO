package vp;
/**
 * A classe JogaCartas contém um método construtor, além de:
 * - sorteiaCartas() : sorteia cartas aleatórias para todas as cartas criadas
 * - sorteiaCartas(int[] mudaCarta) : sorteia aleatoriamente as cartas escolhidas pelo usuário
 * - getCartas(): retorna o vetor de cartas
 * - novaRodada(): Esvazia o vetor sorteou e sorteia cartas aleatoriamente
 * - toString(): Imprime o design da carta
 * 
 * @author Victor Reis, Matheus Rigato
 */
public class JogaCartas {
	private Carta[] cartas;
	private int numCartas = 0;
	private boolean[] sorteou = new boolean[52];
	
        public void sorteiaCartas() {
		int valorCarta;
		
		for(int i = 0; i < numCartas; i++) {
			// Sorteia pela primeira vez
			valorCarta = cartas[i].sorteiaCarta();
			// Sorteia até sortear uma carta nova nessa rodada
			while(sorteou[valorCarta])
				valorCarta = cartas[i].sorteiaCarta();
			
			sorteou[valorCarta] = true;
		}
	}
	
        // Recebe array de parametro, formato:
	// new int[] {1, 2, 4}
	public void sorteiaCartas(int[] mudaCarta) {
		int valorCarta;
		
		// Sorteia apenas cartas no array
		for(int i = 0; i < mudaCarta.length; i++) {
			
                    if(mudaCarta[i] >= 1 && mudaCarta[i] <= numCartas){
                        
                        valorCarta = cartas[(mudaCarta[i] - 1)].sorteiaCarta();
			
			while(sorteou[valorCarta])
                            valorCarta = cartas[(mudaCarta[i] - 1)].sorteiaCarta();
			
			sorteou[valorCarta] = true;
                    }
		}
	}
        
	public JogaCartas(int n) {
		cartas = new Carta[n];
		numCartas = n;
		
		// Inicializa n cartas
		for(int i = 0; i < n; i++) {
			cartas[i] = new Carta();
		}
		
		// Inicializa o array de cartas sorteadas
		for(int i = 0; i < 52; i++) {
			sorteou[i] = false;
		}
                
                sorteiaCartas();
	}
	
	public Carta[] getCartas() {
		return cartas;
	}

	// Usar toda vez que começar nova rodada (nao precisa na primeira)
	public void novaRodada() {
		for(int i = 0; i < 52; i++) {
			sorteou[i] = false;
		}
                
                  sorteiaCartas();
	}
	
	
@Override

	// Exibe as cartas no formato:
    //   0.        1.
    //+------+  +------+
    //|      |  |      |
    //|      |  |      |
    //|  4♦  |  |  5♧  |
    //|      |  |      |
    //|      |  |      |
    //+------+  +------+
	public String toString() {
		String retorno = "   ";
		
		//    1.        2.        etc.
		for(int i = 0; i < numCartas; i++) {
			retorno += (i + 1) + ".";
			if(i != numCartas - 1)
				retorno += "        ";
		}
		retorno += "\n";
		
		// +------+  +------+  etc.
		for(int i = 0; i < numCartas; i++) {
			retorno += "+------+";
			if(i != numCartas - 1)
				retorno += "  ";
		}
		retorno += "\n";
		
		// |      |  |      |  etc.
		for(int i = 0; i < numCartas; i++) {
			retorno += "|      |";
			if(i != numCartas - 1)
				retorno += "  ";
		}
		retorno += "\n";
		
		// |      |  |      |  etc.
		for(int i = 0; i < numCartas; i++) {
			retorno += "|      |";
			if(i != numCartas - 1)
				retorno += "  ";
		}
		retorno += "\n";
		
		// |  4♦  |  |  5♧  |  etc.
		for(int i = 0; i < numCartas; i++) {
			retorno += "|  " + cartas[i].toString() + "  |";
			if(i != numCartas - 1)
				retorno += "  ";
		}
		retorno += "\n";
		
		// |      |  |      |  etc.
		for(int i = 0; i < numCartas; i++) {
			retorno += "|      |";
			if(i != numCartas - 1)
				retorno += "  ";
		}
		retorno += "\n";
		
		// |      |  |      |  etc.
		for(int i = 0; i < numCartas; i++) {
			retorno += "|      |";
			if(i != numCartas - 1)
				retorno += "  ";
		}
		retorno += "\n";
		
		// +------+  +------+  etc.
		for(int i = 0; i < numCartas; i++) {
			retorno += "+------+";
			if(i != numCartas - 1)
				retorno += "  ";
		}
		retorno += "\n";
		
		return retorno;
	}
}
