public class MainAPp {

	public static void main(String[] args){
		int vuoleGiocare = 1;
		System.out.println("Benvenuto nel gioco TamaGolem");
		CostantiDiGioco.delimita();
		do{
			Partita p = new Partita();
			vuoleGiocare = InputDati.leggiIntero("Sembra che il tuo combattimento sia arrivato alla fine!\nVuoi giocare una nuova partita?\n1 per si\n0 per uscire\n");
		}while(vuoleGiocare==1);
	}
}