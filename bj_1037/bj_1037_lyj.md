문제 회고를 위해 알고리즘 풀이 기록을 남깁니다.

# 백준 문제번호 문제제목
[1037 약수](https://www.acmicpc.net/problem/1037)

### 문제 이해하기
1. N의 진짜 약수가 주어질 때 N을 구하는 문제 단, 진짜 약수는 1, N이 아닌 N의 약수
 

### 문제 접근 방법
1. 12의 약수 1, 2, 3, 4, 6, 12가 있을 때 12를 찾아내기 위해서는 1*12, 2*6, 3*4을
해주면 N을 찾을 수 있다 이런 메커니즘을 통해 제일 작은 약수와 제일 큰 약수를 곱해주면 N을 구할 수 있다.


### 구현 배경 지식
1. 약수의 성질


### 접근 방법을 적용한 코드
```java
import java.util.*;

public class bj_1037_lyj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }
        System.out.println(Collections.max(list) * Collections.min(list));
    }
}
```

