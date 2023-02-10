문제 회고를 위해 알고리즘 풀이 기록을 남깁니다.

# 백준 문제번호 문제제목
[6588_골드바흐의추측](https://www.acmicpc.net/problem/6588)

### 문제 이해하기
`입력으로 받은 짝수 n을 두 홀수 소수의 합으로 나타내는 문제`
 

### 문제 접근 방법
```
n의 최대 범위가 1000000이기 때문에 시간초과를 잡아야 한다.
시간 초과를 해결하기 위해 에라스토테네스의 체 방법을 사용했고
사용한 루프들에서 홀수만 확인하는 식으로 하여 최대한 시간을 줄이려고 했다.
```


### 구현 배경 지식
`에라토스 테네스의 체`



### 접근 방법을 적용한 코드
```java
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
```

