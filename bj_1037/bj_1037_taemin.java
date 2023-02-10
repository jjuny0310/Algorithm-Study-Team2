package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1037_taemin {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 약수의 개수
		int num = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 약수를 잠시 담을 변수, 일단 가장 첫번째 약수를 담도록 함
		int temp = Integer.parseInt(st.nextToken());
		
		// 가장 첫번째 약수로 min, max를 초기화
		int min = temp, max = temp;
		for(int i=1; i<num; i++) {
			temp = Integer.parseInt(st.nextToken());
			if(max < temp) max = temp;
			if(min > temp) min = temp;
		}
		
		// 가장 작은 약수 * 가장 큰 약수
		// 약수의 개수가 하나면 그 약수 제곱하게 됨
		System.out.println(min * max);
	}

}