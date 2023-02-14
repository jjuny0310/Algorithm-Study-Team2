문제 회고를 위해 알고리즘 풀이 기록을 남깁니다.

# 백준 문제번호 문제제목
[1476 날짜 계산](https://www.acmicpc.net/problem/1476)

### 문제 이해하기
1. 준규가 사는 나라는 E, S, M으로 날짜를 나타내고 E, S, M 각각의 날짜 범위가 존재하는데
E, S, M의 연도를 가지고 우리가 알고 있는 연도를 구하는 문제
 

### 문제 접근 방법
1. 입력으로 들어오는 E, S, M을 각각 주어진 범위에 맞게 나머지 연산을 수행하였다.
2. 주어진 범위는 1부터 시작인데 나머지 연산은 0부터 시작이기 때문에 범위를 1빼주었고, 
입력값에 맞을때 까지 연도를 1씩 더하는 방식으로 탐색을 수행하였다.


### 구현 배경 지식
1. 나머지 연산(모듈러)



### 접근 방법을 적용한 코드
```java
import java.util.Scanner;

public class bj_1476_lyj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt() - 1;
        int S = sc.nextInt() - 1;
        int M = sc.nextInt() - 1;

        int e = -1;
        int s = -1;
        int m = -1;
        int year = 0;
        while (true) {
            e = (e + 1) % 15;
            s = (s + 1) % 28;
            m = (m + 1) % 19;
            year++;
            if (e == E && s == S && M == m) {
                System.out.println(year);
                break;
            }
        }
    }
}
```

