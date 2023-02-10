문제 회고를 위해 알고리즘 풀이 기록을 남깁니다.

# 백준 문제번호 문제제목
[2609 최대공약수와 최소공배수](https://www.acmicpc.net/problem/2609)

### 문제 이해하기
1. 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램
 

### 문제 접근 방법
1. 최대 공약수를 유클리드 알고리즘을 통해 접근
2. 최소 공배수는 두 수의 곱을 최대 공약수로 나누어주면 구할 수 있음 


### 구현 배경 지식
1. 최대 공약수을 구하는 gcd 이해
2. 최소 공배수 공식 이해

### 접근 방법을 적용한 코드
```java
import java.util.Scanner;

public class bj_2609_lyj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = gcd(a, b);
        System.out.println(gcd);
        System.out.println(a * b / gcd);
    }

    static int gcd(int a, int b) {
        while (b != 0){
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}
```

