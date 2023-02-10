package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_17427_taemin {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long total = 0;
		// N까지의 각 숫자의 개수와 숫자를 곱함
		for(int i=1; i<=N; i++) {
			total += i * (N/i);
		}
		System.out.println(total);
	}
}