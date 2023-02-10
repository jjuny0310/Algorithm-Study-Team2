문제 회고를 위해 알고리즘 풀이 기록을 남깁니다.

# 백준 문제번호 문제제목
[17427_약수의합2](https://www.acmicpc.net/problem/17427)

### 문제 이해하기
`N이 주어질 때, 1부터 N의 모든 약수의 합을 출력하는 문제`
 

### 문제 접근 방법
```
각 숫자의 배수는 약수로 그 숫자를 가지기 때문에 각 숫자들의 개수를 이용.
N이 4라고 한다면 각 숫자의 개수는 아래와 같다.

1
1 2
1 3
1 2 4

각 숫자들의 개수는 N/숫자가 된다.
```

### 구현 배경 지식
`약수`



### 접근 방법을 적용한 코드
```java
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
```

