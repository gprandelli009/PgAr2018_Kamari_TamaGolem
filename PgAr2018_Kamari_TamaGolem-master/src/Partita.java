public class Partita {
	CostantiDiGioco cost;
	Equilibrio e;
	Giocatore g1,g2;

	public Partita() {
		CostantiDiGioco.costanti();
		ScortaDiPietre.inizializza();
		e = new Equilibrio();
		g1 = new Giocatore("Pino(P.1)");
		CostantiDiGioco.delimita();
		g2 = new Giocatore("Gino(P.2)");
		CostantiDiGioco.delimita();

		boolean g1StillAlive=true,g2StillAlive=true;

		do{
			int pG1 = g1.getPietra();
			String nomepG1 = ScortaDiPietre.nomi[pG1-1];
			int pG2 = g2.getPietra();
			String nomepG2 = ScortaDiPietre.nomi[pG2-1];
			System.out.printf("Tama di %s scaglia pietra %s \n",g1.getNomeGiocatore(),nomepG1);
			System.out.printf("Tama di %s scaglia pietra %s \n",g2.getNomeGiocatore(),nomepG2);
			int danno = e.calcolaDanno(pG1,pG2);
			if(danno>0) {
				g2StillAlive = g2.infliggiDanno(danno);
			}
			else if(danno<0) {
				g1StillAlive = g1.infliggiDanno(Math.abs(danno));
			}
			else
				System.out.println("Due pietre dello stesso elemento si annullano");
			CostantiDiGioco.delimita();
		}while(g1StillAlive && g2StillAlive);

		if(g1StillAlive) System.out.println("Il giocatore 1 ha vinto");
		else System.out.println("Il giocatore 2 ha vinto");

		System.out.println(e.toString());
		CostantiDiGioco.delimita();
	}
}