package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj_6588_taemin {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		boolean[] isNotPrime = new boolean[1000000];
		for(int i=3; i<1000000; i+=2) {
			if(isNotPrime[i] == true) continue;
			for(int j = i*2; j<1000000; j+=i)
				isNotPrime[j] = true;
		}
		
		
		while(true) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) break;
			
			for(int temp=3;; temp+=2) {
				if(isNotPrime[temp] == true) continue;
				if(temp > num/2) {
					sb.append("Goldbach's conjecture is wrong.\n");
					break;
				}
				
				if(isNotPrime[num - temp] == false) {
					sb.append(num).append(" = ").append(temp).append(" + ").append(num - temp).append("\n");
					break;
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}

}
