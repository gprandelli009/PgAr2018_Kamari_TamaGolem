public class Partita {
	private static final int MAX_INTERAZIONI = 15;
	private CostantiDiGioco cost;
	private Equilibrio e;
	private Giocatore g1, g2;
	private static final String MSG_PAREGGIO = "Pareggio!\n" +
			"Gli avventurieri rimasero bloccati per eoni perch� i loro elementi si equivalevano\n" +
			"Vuoi effettuare una nuova partita? Per� stavolta sii pi� prudente con la scelta degli elementi\n" +
			"se non vuoi rimanere bloccato di nuovo per anni\n";

	public Partita() {
		CostantiDiGioco.costanti(); //Inizializzo le costanti di gioco
		ScortaDiPietre.inizializza(); //Inizializzo la scorta comune di pietre
		e = new Equilibrio();

		String nomeGiocatore;
		nomeGiocatore = InputDati.leggiStringa("Inserisci nome player1 : ");
		g1 = new Giocatore(nomeGiocatore);
		CostantiDiGioco.delimita();
		nomeGiocatore = InputDati.leggiStringa("Inserisci nome player2 : ");
		g2 = new Giocatore(nomeGiocatore);
		CostantiDiGioco.delimita();

		boolean g1StillAlive = true, g2StillAlive = true;
		int conta = 0;

		do {

			//Memorizzo il tipo di pietra e il nome di entrambi i tama
			int pG1 = g1.getPietra();
			String nomepG1 = ScortaDiPietre.nomi[pG1 - 1];
			int pG2 = g2.getPietra();
			String nomepG2 = ScortaDiPietre.nomi[pG2 - 1];

			System.out.printf("Tama di %s scaglia pietra %s \n", g1.getNomeGiocatore(), nomepG1);
			System.out.printf("Tama di %s scaglia pietra %s \n", g2.getNomeGiocatore(), nomepG2);

			/*Controllo nell'equilibrio il risultato dell'interazione tra le due pietre che sono state lanciate,
			 * se il numero ritornato e` intero significa che la prima pietra "vince" infliggendo "danno" danni al
			 * tama del giocatore2, se il numero e` negativo il contrario.
			 * La variabile conta controlla che tutte le pietre in pancia ai due tama non si annullino a vicenda
			 * evitando la creazione di un loop infinito*/
			int danno = e.calcolaDanno(pG1, pG2);
			if (danno > 0) {
				g2StillAlive = g2.infliggiDanno(danno);
				conta = 0;
			} else if (danno < 0) {
				g1StillAlive = g1.infliggiDanno(Math.abs(danno));
				conta = 0;
			} else {
				System.out.println("Due pietre dello stesso elemento si annullano");
				conta++;
			}
			CostantiDiGioco.delimita();
			//Le due variabili booleane controllano se uno dei due giocatori ha finito i tama a disposizione
		} while (g1StillAlive && g2StillAlive && conta < CostantiDiGioco.p);

		//Controllo perche` si e` interrotto il ciclo e agisco di conseguenza
		if (conta == CostantiDiGioco.p)
			System.out.println(MSG_PAREGGIO);
		else {
			if (g1StillAlive) System.out.printf("%s ha vinto!\n",g1.getNomeGiocatore());
			else System.out.printf("%s ha vinto!\n",g2.getNomeGiocatore());
			CostantiDiGioco.delimita();
		}

		//Stampo l'equilibrio della partita
		System.out.println("Ecco la tabella degli equilibri\n");
		System.out.println(e.toString());
		CostantiDiGioco.delimita();
	}
}