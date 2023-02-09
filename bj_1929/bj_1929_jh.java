package backjoon.bj_1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_1929_jh {
	static boolean[] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		memo = new boolean[end + 1];
		memo[1] = true;

		// 에라토스테네스의 체
		for (int i = 2; i <= end; i++) {
			if (!memo[i]) {
				for (int j = i*2; j <= end; j += i) {
					memo[j] |= true;
				}
			}
		}

		for (int i = start; i <= end; i++) {
			if (!memo[i])
				System.out.println(i);

		}
	}

}
