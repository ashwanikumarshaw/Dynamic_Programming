package climbStairs;

import java.util.Scanner;

//Question
//1. You are given a number n, representing the number of stairs in a staircase.
//2. You are on the 0th step and are required to climb to the top.
//3. You are given n numbers, where ith element's value represents 
//  - till how far from the step you could jump to in a single move.  
//  You can of-course fewer number of steps in the move.
//4. You are required to print the number of minimum moves in 
//  which you can reach the top of staircase.
//Note -> If there is no path through the staircase print null.

public class ClimbStairs_MinimumMoves {

	static public  void main(String[] args) {
		int MAX=Integer.MAX_VALUE;
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt();
		int[] ar=new int[n];
		for(int i=0;i<n;i++)
			ar[i]=sc.nextInt();
		sc.close();
		int[] dp=new int[n+1];
		for(int i=0;i<n+1;i++)
			dp[i]=MAX;
		dp[n]=0;
		
		for(int i=n-1;i>=0;i--) {
			int min=MAX;
			for(int j=1;j<=ar[i]&&i+j<=n+1;j++) {
				if(dp[i+j]!=MAX)
				min=Math.min(min, dp[i+j]);
			}
			if(min!=MAX) {
				dp[i]=min+1;
			}
		}
	
		System.out.println(dp[0]);

	}

}
