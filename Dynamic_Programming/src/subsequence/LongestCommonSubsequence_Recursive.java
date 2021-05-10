package subsequence;
//Optimal Substructure
public class LongestCommonSubsequence_Recursive {

	public int Subseq_Size(String s1,String s2,int m,int n) 
	  { 
	    if (m == 0 || n == 0) 
	      return 0; 
	    if (s1.charAt(m-1) == s2.charAt(n-1)) 
	      return 1 + Subseq_Size(s1, s2, m-1, n-1); 
	    else
	      return max(Subseq_Size(s1, s2, m, n-1), Subseq_Size(s1, s2, m-1, n)); 
	  } 
	
	private int max(int i, int j) {
		
		return i>j?i:j;
	}
	public static void main(String[] args) {
		String s1="abcde",s2="abxcd";
		LongestCommonSubsequence_Recursive f =new LongestCommonSubsequence_Recursive();
		int m=s1.length(), n=s2.length();
		System.out.println(m+""+s1.charAt(4)+n+s2);
		int ne=(f.Subseq_Size(s1, s2, m,n));
		System.out.println(ne);

	}

}
