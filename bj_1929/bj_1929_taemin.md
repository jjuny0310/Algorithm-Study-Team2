문제 회고를 위해 알고리즘 풀이 기록을 남깁니다.

# 백준 문제번호 문제제목
[1929_소수구하기](https://www.acmicpc.net/problem/1929)

### 문제 이해하기
`입력받은 M, N에 대해 해당 범위 안에 있는 소수를 모두 출력하는 문제`
 

### 문제 접근 방법
`루프를 통해 소수를 판별`


### 구현 배경 지식
`소수`



### 접근 방법을 적용한 코드
```java
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
```

