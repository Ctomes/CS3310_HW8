
public class q30 {
	int n = 4;
	int[] vindex = new int[4];
	boolean W[][] = new boolean[4][4];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	void hamiltonian(int i) {
		int j;
		if(promising(i)) {
			if(i==n-1) {
			//	printRoute();
			}
			else {
				for(j=2; j<=n;j++) {
					vindex[i+1] = j;
					hamiltonian(i+1);
				}
			}
		}
	}
	private boolean promising(int i) {
		int j;
		boolean bool;
	//	if(i==n-1 && !W[vindex[n-1]]){
			bool =false;
		}
	//	else if(i>0 && !W[vindex[i-1]]){
			bool = false;
		}
		else {
			bool = true;
			j =1;
			while(j<i && bool) {
				if(vindex[i] == vindex[j]) {
					bool = false;
				}
				++j;
			}
			
		}
		return false;
	}

}
