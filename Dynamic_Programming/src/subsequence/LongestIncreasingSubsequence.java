package subsequence;

public class LongestIncreasingSubsequence {
	
	final int MAX = 100;
	final int in = 1;
	int[] L = new int[MAX];

	public void _ins() {
		for (int i = 0; i < MAX; i++) {
			L[i] = in;
		}
	}
	
	public int find(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++)
				if (arr[i] > arr[j] && L[i] < L[j] + 1)
					L[i] = L[j] + 1;
		}
		int max = 0;
		for (int i = 0; i < n; i++)
			if (max < L[i])
				max = L[i];
		return max;

	}

	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = arr.length;
		LongestIncreasingSubsequence f = new LongestIncreasingSubsequence();
		f._ins();
		int maxSize = f.find(arr, n);
		System.out.println(maxSize);

	}

}
