/*
 * q16.java
 * 11/16/2020
 * Tomes, Christopher
 * This is the complete implementation for Question 16.
 */
public class q16 {
	/*
	 * Global variables including set,
	 * value to find,
	 * an array to find set that adds to W
	 * and a bool to check wether a answer has been found.
	 */
	int w[] = {0,5,6,10,11,16};
	int W=21;
	boolean include[] = new boolean[6];
	boolean found = false;
	/*
	 * driver for question 16
	 * Begin algorithm with 
	 */
	public static void main(String[] args) {
		q16 ob = new q16();
		ob.sum_of_subsets(0,0,48);

	}
	/*
	 * Implementation for sum of subsets.
	 */
	private void sum_of_subsets(int i, int weight, int total) {
		if(promising(i,weight,total)&&!found) {
			if(weight == W) 
			{
				found = true;
				printDigits();
			}else 
			{
				include[i+1]=true;
				sum_of_subsets(i+1, weight + w[i+1],total - w[i+1]);
				include[i+1]=false;
				sum_of_subsets(i+1, weight,total-w[i+1]);
			}
		}
		
	}
	/*
	 * function to print subset
	 */
	private void printDigits() {
		System.out.print("One of the solutions is: {");
		for(int i = 0; i < w.length; i++) {
			if(include[i])
				
			System.out.print("["+w[i]+"]");
		}
		System.out.println("} = " + W);

		
	}
	/*
	 * Promising function.
	 */
	private boolean promising(int i,int weight,int total) {
		return(weight+total>=W)&&(weight==W||weight+w[i+1]<=W);
	}
}
