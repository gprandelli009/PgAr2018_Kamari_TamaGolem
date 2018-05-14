import java.util.Random;

public class Equilibrio {
	private int n;
	private int[][] array;

	public Equilibrio() {
		n= CostantiDiGioco.n;
		int vita=CostantiDiGioco.v;
		int i,j,k;
		int somma=0;
		Random random = new Random();
		array = new int[n][n];
		boolean reinizia= false;
		do {
			//System.out.println("Inizio");
			reinizia= false;
			for (i=0;i<n;i++) {
		
				do {
					for (j=i;j<n;j++) {
						if(i==j) {
							array[i][j]=0;
							if(i==n-1)
								somma=1;
						}
						else
						{  //con questo passaggio l'ultimo valore lo calcolo facendo
							// la differenza con la somma dei danni che fa(positivo) e
							//riceve(neg) se la somma fa 0 reinizio il ciclo da capo
							if(j==n-1) {
								for(k=0;k<n;k++) {
									somma=somma+array[i][k];
								}
								array[i][j]=-somma;
								array[j][i]=somma;
				
								if ( (i == n-2) && (somma==0 || Math.abs(somma)>vita)) reinizia=true;
							}
							else {
								do {
									array[i][j]=numeroRandom(random,vita);
									array[j][i]=-array[i][j];
								
								}
								while(array[i][j]==0);
							}
						}
					}
					//System.out.println("la somma vale "+somma);
					if(reinizia) break;
				}
				while((Math.abs(somma)>vita || somma==0));
				somma=0;
			}
		}while (reinizia);

	}

	private int numeroRandom(Random random, int vita) {
		return (random.nextInt(vita+1) -5);
	}

	public int calcolaDanno(int p1,int p2){
		return array[p2-1][p1-1];
	}

	public String toString(){
		StringBuilder s = new StringBuilder();

		s.append(String.format("%10s","_DANNI_"));
		for(int i=0;i<n;i++){
			s.append(String.format("%10s",ScortaDiPietre.nomi[i]));
		}
		s.append(System.lineSeparator());
		for (int i=0;i<n;i++) {
			s.append(String.format("%10s",ScortaDiPietre.nomi[i]));
			for (int j=0;j<n;j++) {
				s.append(String.format("%10d",array[i][j]));
			}
			s.append(System.lineSeparator());
		}
		return s.toString();
	}

}


