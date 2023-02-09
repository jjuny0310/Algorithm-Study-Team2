package backjoon.bj_1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1987_jh {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer =0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(n-->0) {
			int num = Integer.parseInt(st.nextToken());
			if(isPrime(num))
				answer++;
		}
		System.out.println(answer);
	}
	
	public static boolean isPrime(int num) {
		if(num == 1)
			return false;
		
		for(int i=2; i*i<=num; i++)
			if(num%i == 0)
				return false;
		return true;
	}

}
