import java.util.Random;

public class MainTamagolem {

	public static void main(String[] args) {
		int n=10;
		int i,j,k;
		int somma=0;
		int vita=10;
		Random random = new Random();
		int[][] array = new int[10][10];

		for (i=0;i<n;i++) {
			do {
				for (j=i;j<n;j++) {
					if(i==j) {
						array[i][j]=0;
						if(i==n-1)
							somma=1;
					}
					else
					{ 
						if(j==n-1) {
							for(k=0;k<n;k++) {
								somma=somma+array[i][k];
							}
							array[i][j]=-somma;
							array[j][i]=somma;
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
				System.out.println("la somma vale "+somma);
			}
			while(Math.abs(somma)>vita || somma==0);
			somma=0;
		}

		for (i=0;i<n;i++) {
			for (j=0;j<n;j++) {
				System.out.printf("%4d",array[i][j]);
			}
			System.out.print("\n");
		}

	}

	public static int numeroRandom(Random random, double vita) {
		int vitas=(int) vita;
		return (random.nextInt(vitas+1) -5);
	}


}


