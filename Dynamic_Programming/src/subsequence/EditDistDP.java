package subsequence;

public class EditDistDP {
	public int  find(String s1,String s2 ) {
		
		s1 ="0"+s1;
		s2 ="0"+s2;

		int m=s1.length(),n=s2.length();
		int[][] L=new int[m+1][n+1];
		for (int i =0 ;i<m;i++) {
			for(int j=0;j<n;j++) {
			if(i==0)
				L[i][j]=j;
			else if(j==0)
				L[i][j]=i;
			else if (s1.charAt(i)==s2.charAt(j))
				L[i][j]=L[i-1][j-1];
			else
				L[i][j]=min(L[i-1][j],L[i][j-1],L[i-1][j-1])+1;
				
			
			//System.out.print( L[i][j]+"  ");//Table
			}//System.out.println("");
			
		}
		return L[m-1][n-1];
	}

	private int min(int i, int j, int k) {
		// TODO Auto-generated method stub
		return i<j? i<k?i:k : j<k?j:k;
	}

	public static void main(String[] args) {
		String s1="sunday",s2="saturday";

		EditDistDP f=new EditDistDP();
		int out=f.find(s1, s2);
		System.out.println("Num of operation ="+out);
		

	}

}
