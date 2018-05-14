public class Tama {
	private int[] pancia;
	private int indicePancia = 0, v;

	public Tama() {
		this.v = CostantiDiGioco.v; //Vita del tama
		int p = CostantiDiGioco.p; //Pietre in pancia

		//Riempio la pancia
		pancia = new int[p];
		for (int i = 0; i < p; i++) {
			System.out.println("Scegli la pietra da caricare nel tama in posizione " + (i + 1));
			pancia[i] = ScortaDiPietre.scegliPietra();
		}
	}

	public int infliggiDanno(int danno) {
		v -= danno;
		return v;
	}

	public int scagliaPietra() {
		int pietra = pancia[indicePancia];
		if (indicePancia < CostantiDiGioco.p - 1) indicePancia++;
		else indicePancia = 0;//Azzero il contatore quando e` arrivato all'ultimo elemento dell pancia
		return pietra;
	}
}