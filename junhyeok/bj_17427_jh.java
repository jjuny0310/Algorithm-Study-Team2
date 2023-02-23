package backjoon.bj_17427;

import java.util.Scanner;

public class bj_17427_jh {
	public static void main(String[] args) {
		System.out.println(g(new Scanner(System.in).nextInt()));
	}
	
	public static long g(int n) {
		long result = 0;
		for (int i = 1; i <= n; i++) {
			result += n/i*i;
		}

		return result;
	}

}