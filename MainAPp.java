public class MainAPp {

	public static void main(String[] args){
		int vuoleGiocare = 1;
		System.out.println("Benvenuto nel gioco TamaGolem");
		CostantiDiGioco.delimita();
		do{
			Partita p = new Partita();
			vuoleGiocare = InputDati.leggiIntero("Vuoi giocare una nuova partita?\n1 per si\n0 per uscire");
		}while(vuoleGiocare==1);
	}
}
