문제 회고를 위해 알고리즘 풀이 기록을 남깁니다.

# 백준 문제번호 문제제목
[문제번호 문제제목](https://www.acmicpc.net/problem/2309)

### 문제 이해하기
1. 9명의 난쟁이 중 키의 합계가 100이 되는 7명의 난쟁이를 구하는 문제
 

### 문제 접근 방법
1. 조합으로 9개중에 7개를 선택하는 모든 경우의 수를 구하고 합계가 100이 되면
해당 조합을 선택하였다.


### 구현 배경 지식
1. 순열과 조합


### 접근 방법을 적용한 코드
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class bj_2309_lyj {
    static int[] numbers;
    static int[] arr;
    static List<int[]> answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[9];
        numbers = new int[7];
        answer = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }
        combination(0, 0);

        for (int i = 0; i < answer.get(0).length; i++) {
            System.out.println(answer.get(0)[i]);
        }
    }

    static void combination(int depth, int start) {
        if (depth == numbers.length) {
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum += numbers[i];
            }
            if (sum == 100) {
                int[] newArr = Arrays.copyOfRange(numbers, 0, numbers.length);
                Arrays.sort(newArr);
                answer.add(newArr);
            }
            return;
        }

        for (int i = start; i < arr.length; i++) {
            numbers[depth] = arr[i];
            combination(depth + 1, i + 1);
        }
    }
}
```

