package _2D_problems;

import java.util.Scanner;

/*
 * Goldmine
 * Question
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, 
	which represents a gold mine.
4. You are standing in front of left wall and are supposed to dig to 
	the right wall. You can start from any row in the left wall.
5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) 
	or 1 cell right-down(d3)
 */
public class Goldmine {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n =sc.nextInt();
		int m=sc.nextInt();
		int[][] arr= new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		int [][] qa=new int[n+1][m+1];
		for(int i=n-1;i>=0;i--) {
					qa[i][m-1]=arr[i][m-1];
			}
		for(int j=m-1;j>=0;j--) {
			for(int i=n-1;i>=0;i--) {
				if(i==n-1) {
					qa[i][j]=arr[i][j]+Math.max(qa[i][j+1], qa[i-1][j+1]);
				}
				else if(i==0) {
					qa[i][j]=arr[i][j]+Math.max(qa[i][j+1], qa[i+1][j+1]);
				}
				else {
					qa[i][j]=arr[i][j]+Math.max(qa[i][j+1], Math.max(qa[i-1][j+1], qa[i+1][j+1]));
				}
			}
		}
		
		for(int i=n-1;i>=0;i--) {
			for(int j=m-1;j>=0;j--) {
				System.out.print(qa[i][j] + " ");
			}
			System.out.println();
		}
			int max=qa[0][0];
			for(int i1=1;i1<n;i1++) {
				if(qa[i1][0]>max) {
					max=qa[i1][0];
				}
				}
		System.out.println(max);
		sc.close();

	}
	/*
	 * test data :
6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1
	 */

}
