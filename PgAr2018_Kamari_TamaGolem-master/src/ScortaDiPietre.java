public class ScortaDiPietre {
	public static int[] scorta;
	public static String[] nomi =
			{"Fuoco        (1)",
					"Acqua        (2)",
					"Terra        (3)",
					"Aria         (4)",
					"Veleno       (5)",
					"Magma        (6)",
					"Luce         (7)",
					"Gas          (8)",
					"Elettricit�  (9)",
					"Piombo      (10)"};

	/*Creo l'array (corrispettivo a quello dei nomi) scorta che conterra` quante pietre di un determinato
	 * tipo rimangono nella scorta comune*/
	public static void inizializza() {
		int n = CostantiDiGioco.n;
		scorta = new int[n];

		for (int i = 0; i < n; i++) {
			scorta[i] = CostantiDiGioco.st;
		}
	}

	public static int scegliPietra() {
		for (int i = 0; i < CostantiDiGioco.n; i++) {
			if (scorta[i] != 1)
				System.out.printf("Rimangono %d pietre di %s \n", scorta[i], nomi[i]);
			else
				System.out.printf("Ti rimane %d pietra di %s \n", scorta[i], nomi[i]);
		}

		int scelta;
		do {
			scelta = InputDati.leggiIntero("Inserisci la tua scelta : ", 1, CostantiDiGioco.n);
		} while (scorta[scelta - 1] == 0); //Controllo che del tipo scelto ci siano ancora pietre a disposizione
		System.out.println();
		scorta[scelta - 1]--;
		return scelta;
	}

}