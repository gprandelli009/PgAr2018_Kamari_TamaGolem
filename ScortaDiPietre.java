public class ScortaDiPietre {
	public static int[] scorta;
	public static String[] nomi =
			{"fuoco (1)","acqua (2)","terra (3)","aria (4)","veleno (5)","magma(6)","luce(7)","gas(8)","caramello(9)","piombo(10)"};

	public static void inizializza(){
		int n = CostantiDiGioco.n;
		scorta = new int[n];
		for(int i=0;i<n; i++){
			scorta[i] = CostantiDiGioco.st;
		}
	}

	public static int scegliPietra(){
		for(int i=0;i<CostantiDiGioco.n;i++){
			System.out.printf("Rimangono %d pietre %s \n",scorta[i],nomi[i]);
		}
		int scelta;
		do {
			scelta = InputDati.leggiIntero("Inserisci la tua scelta : ", 1, CostantiDiGioco.n);
		}while(scorta[scelta-1]==0);
		scorta[scelta-1]--;
		return scelta;
	}

}
