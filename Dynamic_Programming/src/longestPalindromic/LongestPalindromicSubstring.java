package longestPalindromic;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String s="ASSSSAHAgAH";
		int l=lps(s);
		System.out.println(l);
		
		System.out.println(longestPalindrome("ac"));
	}

	static int lps(String seq) 
    { 
    int n = seq.length(); 
    int i, j, cl; 
    // Create a table to store results of subproblems 
    int L[][] = new int[n][n];  
      
    // Strings of length 1 are palindrome of lentgh 1 
    for (i = 0; i < n; i++) 
        L[i][i] = 1; 
              
        // Build the table. Note that the lower  
        // diagonal values of table are 
        // useless and not filled in the process.  
        // The values are filled in a manner similar 
        //  to Matrix Chain Multiplication DP solution (See 
        // https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/).  
        // cl is length of substring 
        for (cl=2; cl<=n; cl++) 
        { 
            for (i=0; i<n-cl+1; i++) 
            { 
                j = i+cl-1; 
                if (seq.charAt(i) == seq.charAt(j) && cl == 2) 
                L[i][j] = 2; 
                else if (seq.charAt(i) == seq.charAt(j)) 
                L[i][j] = L[i+1][j-1] + 2; 
                else
                L[i][j] = Math.max(L[i][j-1], L[i+1][j]); 
            } 
        } 
              
        return L[0][n-1]; 
    } 

	
	//LeetCode
	public static String longestPalindrome(String s) {
        if(s==null || s.length()<=1)
        return s;
 
    int len = s.length();
    int maxLen = 1;
    boolean [][] dp = new boolean[len][len];
 
    String longest = null;
    for(int l=0; l<s.length(); l++){
        for(int i=0; i<len-l; i++){
            int j = i+l;
            if(s.charAt(i)==s.charAt(j) && (j-i<=2||dp[i+1][j-1])){
                dp[i][j]=true;
                
                System.out.println(j-i+1);
                if(j-i+1>=maxLen){
                   maxLen = j-i+1; 
                   longest = s.substring(i, j+1);
                }
            }
        }
    }
 
    return longest;
  
    }
}
