문제 회고를 위해 알고리즘 풀이 기록을 남깁니다.

# 백준 문제번호 문제제목
[1978_소수찾기](https://www.acmicpc.net/problem/1978)

### 문제 이해하기
`주어진 N개의 수 중 소수의 개수를 출력하는 문제`
 

### 문제 접근 방법
`루프를 통해 약수의 유무를 파악함`


### 구현 배경 지식
`소수`



### 접근 방법을 적용한 코드
```java
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
```

