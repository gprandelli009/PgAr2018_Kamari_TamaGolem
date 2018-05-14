import java.util.Random;

public class Equilibrio {
	private int n;
	private int[][] array;

	public Equilibrio() {
		n = CostantiDiGioco.n;
		int vita = CostantiDiGioco.v;
		int i, j, k;
		int somma = 0;
		Random random = new Random();
		array = new int[n][n];
		boolean reinizia = false;
		/*
		 *genero i danni che ogni elemento i fa (se pos) o riceve (se negativo)
		 *ad un elemento j.
		 */
		do {
			reinizia = false;
			for (i = 0; i < n; i++) {

				do {
					for (j = i; j < n; j++) {
						if (i == j) {
							array[i][j] = 0; //un elemento a se stesso fa 0 danni
							if (i == n - 1)
								somma = 1;  /* se sono arrivato all'ultimo elemento[i] non serve
										   generare altro perch� i danni che farebbe/riceverebbe 
										   sono gi� stati generati
										   dai valori precedenti di i.*/
						} else {  //con questo passaggio l'ultimo valore di j lo calcolo facendo
							// la differenza con la somma dei danni che fa(positivo) e
							//riceve(neg) se la somma fa 0 e ho i che � il penultimo elemento reinizio
							//da i=0 per evitare un ciclo infinito
							if (j == n - 1) {
								for (k = 0; k < n; k++) {
									somma = somma + array[i][k];
								}
								array[i][j] = -somma;
								array[j][i] = somma;

								if ((i == n - 2) && (somma == 0 || Math.abs(somma) > vita)) reinizia = true;
							} else {
								do {
									array[i][j] = numeroRandom(random, vita); //negli altri casi genero un numero casuale in un intervallo
									array[j][i] = -array[i][j];              // (tra -5 e 6 in questo caso) escluso lo 0.
								}
								while (array[i][j] == 0);
							}
						}
					}
					//System.out.println("la somma vale "+somma);
					if (reinizia) break;
				}
				while ((Math.abs(somma) > vita || somma == 0)); //reinizio da j = 0
				somma = 0;
			}
		} while (reinizia); //ricomincio da i=0

	}

	private int numeroRandom(Random random, int vita) {
		return (random.nextInt(vita + 1) - 5);
	}

	public int calcolaDanno(int p1, int p2) {
		return array[p2 - 1][p1 - 1];
	}

	public String toString() {                                                //creazione della tabellina finale che mostra
		StringBuilder s = new StringBuilder();                                //al giocatore le relazioni tra i vari elementi

		s.append(String.format("%10s", "DANNI           |"));
		for (int i = 0; i < n; i++) {
			s.append(String.format(" %10s |", ScortaDiPietre.nomi[i]));
		}
		s.append(System.lineSeparator());
		for (int i = 0; i < n; i++) {
			s.append(String.format("%10s|", ScortaDiPietre.nomi[i]));
			for (int j = 0; j < n; j++) {
				s.append(String.format("        %2d        |", array[i][j]));
			}
			s.append(System.lineSeparator());
		}
		return s.toString();
	}

}