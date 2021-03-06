package climbStairs;

// * Question
//1. You are given a number n, representing the number of stairs in a
//	staircase.
//2. You are on the 0th step and are required to climb to the top.
//3. You are given n numbers, where ith element's value represents 
//  - till how far from the step you could jump to in a single move.  
//   You can of course jump fewer number of steps in the move.
//4. You are required to print the number of different paths via which
//    you can climb to the top.
// 
public class ClimbStairs_VariableJumps {

	public static void main(String[] args) {
		int n = 10;
		int[] jump = { 3, 3, 0, 2, 1, 2, 4, 2, 0, 0 };
		int s=jump.length;
		int[] qa=new int[s+1];
		qa[n]=1;
		for(int i=n-1;i>=0;i--) {
			for(int j=1;j<=jump[i]&&i+j<qa.length;j++) {
				qa[i]+=qa[i+j];
			}
		}
		System.out.println(qa[0]);

	}

}
