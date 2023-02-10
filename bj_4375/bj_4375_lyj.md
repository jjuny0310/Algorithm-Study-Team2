# 문제 풀이 회고
백준 4375번 - 1

## 문제 내용
2와 5로 나누어 떨어지지 않는 정수가 주어졌을 때, 1로만 이루어진 n의 배수를 찾는 프로그램을 작성.

## 접근 방법
1. 1, 11, 111, 1111 ... 순서로 해당 값이 나누어 떨어지는지 확인하고, 나누어 떨어지면 해당 값이 정답이라고 판단
2. 1의 길이만 증가하기 위해 `n * 10 + 1`의 계산식을 활용
3. 자릿수가 커지면 long의 범위를 넘어버릴 수 있어서 BigInteger를 활용
4. 나누어 떨어지는것을 확인하기 위해 mod(%)연산을 활용


## 구현 코드
```
import java.math.BigInteger;
import java.util.Scanner;

public class bj_4375_yj {
    public static int findLength(String input){
        BigInteger n = new BigInteger(input);
        BigInteger value = BigInteger.ZERO;

        while (true) {
            value = value.multiply(BigInteger.TEN).add(BigInteger.ONE);
            if (value.mod(n).equals(BigInteger.ZERO)) {
                return value.toString().length();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int answer = findLength(sc.next());
            System.out.println(answer);
        }
    }
}
```





