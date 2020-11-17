/*
 * q11.java
 * 11/16/2020
 * Tomes, Christopher
 * This is the complete implementation for Question 11.
 */
import java.util.Random;

public class q11 {
	/*Global variables to represent the Board, 
	 *size of the board,
	 *and number of permutations 
	 */
	int col[] = new int[N+1]; //col[] is indexed from 1-N rather than 0-N-1 so col[0] is empty.
	final static int N = 8;
	int counter = 0;
	
	public static void main(String[] args) {

		/*
		 * Driver for Question 16,
		 * This will run the queens problem and print out every permutation
		 * for 8 queens on a chess board. Then, the driver will run 20 instances of
		 * Monte Carlo's Algorithm and print out the average number of nodes. 
		 */
		q11 ob = new q11();
		ob.queens(0);
		
		
		int sampleSize = 20;
		int runingAverage[] = new int[sampleSize];
		for(int i = 0; i<sampleSize;++i) {
			runingAverage[i] = ob.estimate_n_queens(N);
		}
		
		int avg = ob.avg(runingAverage);
		System.out.println("The average number of nodes is:  " + avg);
	}
	/*Simple algorithm to compute average of a set of size 20
	 * 
	 */
	private int avg(int[] n2) {
		double running_sum = 0;
		for(int i = 0; i < n2.length; ++i) {
			running_sum = running_sum + n2[i]/n2.length;
		}
		return (int)running_sum;
	}
	/*
	 * Implementation of Monte Carlo's algorithm.
	 */
	int estimate_n_queens(int n) {//algo 5.3
		int sizeOfProm = 0;
		int i, j;
		int m, mprod, numnodes;
		i = 0;
		numnodes = 1;
		m =1;
		mprod = 1;
		while(m!=0 && i !=N) {
			mprod = mprod*m;
			numnodes = numnodes + mprod*N;
			i++;
			m = 0;
			int[] prom_children = new int[8];
			for(j = 1; j <=N; j++) {
				col[i] = j;
				if(promising(i)) {
					m++;
					prom_children[sizeOfProm++] = j;
				}
				
			}
			if(m!= 0) {
				j = findRandJ(prom_children,sizeOfProm);
				col[i] = j;
				sizeOfProm=0;
			}
			
		}
		return numnodes;
	}
	/*
	 * Given an array of promising children and current size of the set, return
	 * a valid random promising_child. 
	 */
	private int findRandJ(int[] prom_children, int sizeOfProm) {
		Random rand = new Random();
		int r = rand.nextInt(sizeOfProm);
		return prom_children[r];
		
	}
	/*
	 * Implementation of queens problem using recursion.
	 */
	void queens(int i) {
		int j;
		if(promising(i)) 
		{
			if(i==N) 
			{
				System.out.printf("Printing set: %d",++counter);//print permutation of queens problem.
				printBoard();
			}
			else 
			{
				for(j = 1; j <= N; j++ ) 
				{
					col[i+1]=j;

					queens(i+1);
				}
			}
		}

	}
	/*
	 * Print the boards current state.
	 */
	void printBoard() {
		System.out.printf("{");
		for(int i=1; i <=N ;i++) {
			System.out.printf("[%d]",col[i]);
		}
		System.out.println("}");
		
	}
	/*
	 * A function to determine the validity of a particular position for queen to be placed
	 * on the board. Input is the current position on the board.
	 */
	boolean promising(int i) {
		int k = 1;
		boolean bool = true;
		
		while(k<i&& bool) 
		{
			if((col[i] == col[k]) || (abs(col[i]- col[k]) == (i-k)))
			{
				bool =false;
			}
			++k;
		}
		return bool;
	}
	/*
	 * return |i|;
	 */
	private int abs(int i) {
		if(i < 0){
			return -i;
		}	
		return i;
	}

}
