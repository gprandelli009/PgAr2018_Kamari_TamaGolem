public class Giocatore {
	private int g; //Quantita di tama a disposizione
	private Tama tamaCorrente;
	private String nomeGiocatore;

	public Giocatore(String nomeGiocatore) {
		this.g = CostantiDiGioco.g;
		this.nomeGiocatore = nomeGiocatore;
		evocaTama();
	}

	private boolean evocaTama() {
		if (g > 0) {
			System.out.printf("Giocatore %s evoca un nuovo tama \n", nomeGiocatore);
			tamaCorrente = new Tama();
			g--;
			return true; //Ritorno true se il tama e' stato evocato con successo
		}
		return false;//Ritorno false se il giocatore ha finito i tama da sacrificare
	}

	public int getPietra() {
		return tamaCorrente.scagliaPietra();
	}

	public String getNomeGiocatore() {
		return nomeGiocatore;
	}

	public boolean infliggiDanno(int danno) {
		int vitaRimanente = tamaCorrente.infliggiDanno(danno);

		/*Se l'ultima interazione tra pietre ha "ucciso" uno dei due tama (vita <= 0) allora non mostro l'equilibrio
		 * tra le due pietre ma solo un messaggio che informi i giocatori dell'avvenimento.
		 * In caso contrario mostro l'equilibrio tra le due pietre informando quale tama ha subito il danno*/
		if (vitaRimanente <= 0) {
			System.out.printf("Il tama del giocatore %s e` morto \n", nomeGiocatore);
			System.out.printf("Gli rimangono %d tama \n", g);
			CostantiDiGioco.delimita();
			return evocaTama();
		} else
			System.out.printf("Tama di giocatore %s ha subito %d danni \n", nomeGiocatore, danno);
		return true;

	}


}