public class CostantiDiGioco {
	public static int n,g,p,v,s,st;
	public static String delimitatatore = "\n-------------------------------------------------------\n";
	/*
	* g quantita tama per giocatore
	* p pietre per tama
	* v vita tama
	* scorta di pietre (condivisa tra i due giocatori)
	* st quantita di pietre per tipo nella scorta di pietre comune
	*
	* */
	public static void costanti(){
		double diff = InputDati.leggiIntero("Seleziona difficolta` tra 3 e 10 (inversamente proporzionale)",3,10);
		delimita();
		n = (int)diff;
		p = (int)Math.ceil((diff+1)/3)+1;
		g = (int)Math.ceil((diff-1)*(diff-2)/(2*p));
		s = (int)(Math.ceil((2*g*p)/diff)*diff);
		st = (int)Math.ceil((2*g*p)/diff);
		v = 10; //Arbitrario
	}

	public static void delimita(){
		System.out.println(delimitatatore);
	}
}
