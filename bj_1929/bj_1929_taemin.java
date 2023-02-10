package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_1929_taemin {
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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		for(int i=start; i<=end; i++) {
			if(i != 1 && prime(i))
				sb.append(i).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}