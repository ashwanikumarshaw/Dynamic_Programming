package binomialProb;

public class BinomialCoeff {

	public int coefficient(int n,int k) {
		int[][] c=new int[n+1][k+1];
		for(int i =0;i<=n;i++) {
			for(int j=0;j<=min(i,k);j++) {
				if(j==0 ||j==i) 
					c[i][j]=1;
				
				else
					c[i][j]=c[i-1][j-1]+c[i-1][j];
					
			}
		}
		return c[n][k];
		
	}
	private int min(int i, int k) {
		// TODO Auto-generated method stub
		return i<k?i:k;
	}
	public static void main(String[] args) {
		BinomialCoeff f=new BinomialCoeff();
		System.out.println("Binomial Coeff ::"+f.coefficient(5,2));

		//Time(sec) : 0.16Memory(MB) : 48.0625
	}

}
