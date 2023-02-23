문제 회고를 위해 알고리즘 풀이 기록을 남깁니다.

# 백준 문제번호 문제제목
[6588 골드바흐의 추측](https://www.acmicpc.net/problem/6588)

### 문제 이해하기
1. 6 <= n <= 1000000 범위의 짝수 정수가 입력으로 들어오는데, 그 수를 2개 홀수 소수의 합으로
나타낼 수 있으면 가장 큰 차이가 발생하는 두 수를 출력하고, 아니면 특정 문자열을 출력하는 문제이다.
 

### 문제 접근 방법
1. 에라토스테네스의 체를 통해 들어올 수 있는 정수의 최대 범위인 100만까지 미리 소수를 구해놓는다
2. 짝수 정수 n이 들어오면 가장 작은 홀수 소수인 3 ~ n/2 까지 반복문을 수행한다.
3. 반복문 i가 소수이면 합해서 n이 될 수 있는 소수는 n-i이 유일하기 때문에 i가 소수이고 n-i도 소수이면
[i, n-i]의 조합을 정답으로 선택한다.
4. 가장 먼저 찾은 조합이 항상 최대이므로 바로 정답을 출력한다.
5. 조합이 없다면 "Goldbach's conjecture is wrong."를 출력한다.
6. 이 과정을 테스트케이스의 수(최대 10만) 까지 반복한다.


### 구현 배경 지식
1. 에라토스테네스의 체
2. 경우의 수를 모두 다 구하는것이 아닌 i의 조합은 n-i밖에 없다는 것을 파악해야 한다.
3. 입력, 출력의 최적화


### 접근 방법을 적용한 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_6588_lyj {
    static int N = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        findPrimeNumber(isPrime);

        int n = -1;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            boolean isFind = false;
            for (int i = 3; i <= n / 2; i++) {
                if (isPrime[i] && isPrime[n - i]) {
                    sb.append(n).append(" = ").append(i).append(" + ").append(n - i).append("\n");
                    isFind = true;
                    break;
                }
            }
            if (!isFind)
                sb.append("Goldbach's conjecture is wrong.\n");
        }
        System.out.println(sb);
    }

    static void findPrimeNumber(boolean[] isPrime) {
        for (int i = 2; i < (int) Math.sqrt(N) + 1; i++) {
            int j = 2;
            while (j * i <= N) {
                isPrime[j * i] = false;
                j += 1;
            }
        }
    }
}
```

