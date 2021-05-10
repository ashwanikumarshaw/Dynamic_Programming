package knapsack_Problem;

import java.util.Arrays;
import java.util.Scanner;


/*
 * Question
1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number "tar".
4. You are required to calculate and print true or false, if there is a subset the elements of which add 
     up to "tar" or not.
     
Input Format
A number n
n1
n2
.. n number of elements
A number tar

Output Format
true or false as required
 */
public class Target_Sum_Subsets {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		int tar=sc.nextInt();
		
		System.out.println(Solution(arr,tar));		
		sc.close();
	}
/*
 * first we will make a 2d array of length i = length of arr + 1 
 * And length j = tar + 1
 *dp[i][j]|	 tar-x	|	tar-x-1	| ...	|  tar-1  |tar
 * empty |	1	|	0	|  0 	|   0 	  | 0
 * arr[0]|	1	|		|	|	  |
 * arr[1]|	1	|		|	|	  |
 * arr...|	1	|		|	|	  |
 * ...	 |	1	|		|	|	  |
 * arr[n]|	1	|		|	|	  |
 * 
 * now we have travel the dp and check if arr[i] <=j and dp[i-1][j-arr[i]] is true 
 * if true dp[i][j]=true
 * or check dp[i-1][j] was true if true dp[i][j]=true
 * 
 * and at the end return dp[n][tar]
 * 
 */
	 static boolean Solution(int[] arr, int tar) {
		 if(arr==null || arr.length==0) {
			 return false;
		 }
		 else if(arr.length==1&&arr[0]==0) {
			 if(tar==0)
				 return true;
			 else
				 return false;
		 }
		 
		 int n=arr.length;
		 boolean[][] dp =new boolean[n+1][tar+1];
		 
		 //Arrays.sort(arr);
		 
		 for(int i=0;i<dp.length;i++) {
			 for(int j=0;j<dp[0].length;j++) {
				 
				 if(j==0&&i==0) {
					 dp[i][j]=true;
				 }
				 else if(i==0) {
					 dp[i][j]=false;
				 }
				 else  if(j==0) {
					 dp[i][j]=true;
				 }
				 else {
					 if(dp[i-1][j]==true)
						 dp[i][j]=true;
					 else {
						 int val =arr[i-1];
						 if(j >=val) {
							 if(dp[i-1][j-val]==true)
								 dp[i][j]=true;
						 }
						 
					 }
				 }
			 }
		 }
		 
		return dp[n][tar];
	}
	
/*
Sample Input
5
4
2
7
1
3
10
Sample Output
true
 */
}
