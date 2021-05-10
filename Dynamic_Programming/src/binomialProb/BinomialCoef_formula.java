package binomialProb;

public class BinomialCoef_formula {
    public int fact(int n) {
    	int i,fact=1;
    	for(i=1;i<=n;i++)
    	fact=fact*i;
    	return  fact;		
	}
	public static void main(String[] args) {
		BinomialCoef_formula f=new BinomialCoef_formula();
		int c,n=5,k=2;
		//nCk=n!/(k!(n-k)!)
		c=(f.fact(n))/((f.fact(k))*(f.fact(n-k)));
		System.out.println(c);
		//Time(sec) : 0.12 Memory(MB) : 45.6055
	}

}
