package climbStairs;
//Question
//1. You are given a number n, representing the number of stairs in 
//a staircase.
//2. You are on the 0th step and are required to climb to the top.
//3. In one move, you are allowed to climb 1, 2 or 3 stairs.
//4. You are required to print the number of different paths via 
//which you can climb to the top.

public class ClimbStairs {

	public static void main(String[] args) {
		int n = 44;
		int[] qb = new int[n + 1];

		// int sol=climb(n);
		int sol = climb(n, qb);
		System.out.println(sol);

		int sol2 = climb_stairs(n);
		System.out.println(sol2);
	}

	// sol1
	static int climb(int n, int[] qb) {

		if (n == 0)
			return 1;
		else if (n < 0)
			return 0;
		if (qb[n] > 0)
			return qb[n];
		int f1 = climb(n - 1, qb);
		int f2 = climb(n - 2, qb);
		int sol = f1 + f2;
		qb[n] = sol;
		return sol;
	}

	// sol 2 using Tabulation
	static int climb_stairs(int n) {
		if (n <= 1) {
			return 1;
		}

		int[] ways = new int[n + 1];
		ways[0] = 1;
		ways[1] = 1;

		for (int i = 2; i <= n; i++) {
			ways[i] = ways[i - 2] + ways[i - 1];
		}

		return ways[n];
	}

}
