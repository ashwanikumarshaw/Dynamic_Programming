package binomialProb;

public class SpaceOptimizedBinomialCoefficient {

	 int binoCoff(int n,int k) {
		int[] c=new int[k+1];
		c[0]=1;
		for(int i =1;i<=n;i++) {
			for(int j=min(i,k);j>0;j--) 
				c[j]=c[j]+c[j-1];
		}
		return c[k];
	}
	private int min(int i, int k) {
		return i<k?i:k;
	}
	public static void main(String[] args) {
		SpaceOptimizedBinomialCoefficient f=new SpaceOptimizedBinomialCoefficient();
				System.out.println(f.binoCoff(5, 2));

	}

}
