문제 회고를 위해 알고리즘 풀이 기록을 남깁니다.

# 백준 문제번호 문제제목
[1929 소수 구하기](https://www.acmicpc.net/problem/1929)

### 문제 이해하기
1. M이상 N이하의 소수를 모두 출력하는 프로그램
 

### 문제 접근 방법
1. M과 N의 범위가 100만 이내
2. 100만의 범위이므로 에라토스테네스의 체를 활용
3. N까지의 소수를 미리 구해놓고 M ~ N 범위의 반복문을 통해 해당 숫자가 소수인지 판단


### 구현 배경 지식
1. 에라토스테네스의 체


### 접근 방법을 적용한 코드
```java
import java.util.Arrays;
import java.util.Scanner;

public class bj_1929_lyj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int M = sc.nextInt();
        int N = sc.nextInt();

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        check(isPrime);
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    static void check(boolean[] isPrime) {
        for (int i = 2; i < (int) Math.sqrt(isPrime.length) + 1; i++) {
            int j = 2;
            while (j * i < isPrime.length) {
                isPrime[j * i] = false;
                j++;
            }
        }
    }
}
```

