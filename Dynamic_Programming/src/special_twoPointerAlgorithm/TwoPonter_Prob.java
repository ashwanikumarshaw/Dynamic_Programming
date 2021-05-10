package special_twoPointerAlgorithm;

import java.util.Arrays;

public class TwoPonter_Prob {
/*
 * Find the Triplet in an array
 * triplet =>> sum of 3 numb =0
 * it can be solved by  brute force in O(n^3)
 * but by using Two pointer algo it can be solved in O(n^2)
 */
	public static void main(String[] args) {
		int[] a= {5,-4,11,6,-3,7};
		Arrays.sort(a);
		int m=0;
		
		for(int i=0;i<a.length-2;i++) {
			if(twoSum(a,-a[i],i+1)) {
				System.out.println("Triplet");
				m=0;
				break;
			}
			else
				m=1;
				
		}
		if(m==1)
			System.out.println("Not Triplet");

	}
	public static boolean twoSum(int a[],int x,int i) {
		//int i=0;
		int j=a.length-1;
		while(i<j) {
			if(a[i]+a[j]>x)
				j--;
			else if(a[i]+a[j]<x)
				i++;
			else
				return true;
		}
		return false;
	}

}
