package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1978_taemin {
	static boolean prime(int num) {
		int sqrt = (int) Math.sqrt(num);
		
		for(int i=2; i<=sqrt; i++) {
			if(num%i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int count = 0;
		for(int i=0; i<N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(temp != 1 && prime(temp))
				count++;
		}
		System.out.println(count);
	}
}