문제 회고를 위해 알고리즘 풀이 기록을 남깁니다.

# 백준 문제번호 문제제목
[1748 수 이어 쓰기 1](https://www.acmicpc.net/problem/1748)

### 문제 이해하기
1. 1부터 N 까지의 수를 이어쓰면 몇 자리 수 인지 구하는 문제
 

### 문제 접근 방법
1. 최대 N의 개수는 1억, 시간제한은 0.15초이기 때문에 단순한 반복문으로
수를 나열하기에는 1억번의 연산의 평균 소요시간은 1초로 시간이 부족하다.
2. 10까지 1자리 수를 가진 숫자는 9개, 100까지 2자리수를 가진 숫자는 90개 등등
9, 90, 900, 9000...으로 증가하는 규칙이 있다.
3. (N의 자리수 - 1) 만큼 반복문을 수행하여 9*1 + 90*2 + 900*3...을 수행하여
N의 자리수 이전까지는 모두 다 구하고 N은 (N - 10**(N-1)) * N의 자리수의 계산을 통해 구할 수 있다.


### 구현 배경 지식
1. 수학


### 접근 방법을 적용한 코드
```java
import java.util.Scanner;

public class bj_1748_lyj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int length = String.valueOf(N).length();

        int count = 9;
        int answer = 0;
        for (int i = 1; i < length; i++) {
            answer += count * i;
            count *= 10;
        }

        answer += (N - (int) Math.pow(10, length - 1) + 1) * length;
        System.out.println(answer);
    }
}
```

