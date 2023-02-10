문제 회고를 위해 알고리즘 풀이 기록을 남깁니다.

# 백준 문제번호 문제제목
![문제번호 문제제목](https://www.acmicpc.net/problem/1037)

### 문제 이해하기
```
진짜 약수는 1과 N을 제외한 N의 약수들을 의미한다.

첫째 줄에는 N의 진짜 약수의 개수가 주어지고
둘째 줄에는 N의 진짜 약수들이 주어지는데, 진짜 약수들을 이용해 N을 찾는 문제
```


### 문제 접근 방법
진짜 약수들 중 가장 작은 값과 가장 큰 값을 곱하면 N이 된다.


### 구현 배경 지식
약수의 특징



### 접근 방법을 적용한 코드
```java
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
```

