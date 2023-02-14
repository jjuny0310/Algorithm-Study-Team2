문제 회고를 위해 알고리즘 풀이 기록을 남깁니다.

# 백준 문제번호 문제제목
[9095 1, 2, 3 더하기](https://www.acmicpc.net/problem/9095)

### 문제 이해하기
1. 정수가 주어지면 1, 2, 3의 수를 사용해서 해당 정수를 나타낼 수 있는 모든 경우의 수를 구하는 문제
 

### 문제 접근 방법
1. 정수는 최대 10까지 주어지기 때문에 모든 경우의 수를 탐색하는 완전탐색으로 접근하였다.
2. 1이 10개 ~ 3이 10개 까지의 모든 경우의 수를 재귀를 통해 구현하였다.
3. 완전탐색 결과 배열의 합계를 구하고 합계가 10이하이면 해당 합계 인덱스에 1씩 증가하는 방식으로 개수를 더해준
새로운 배열을 생성하여 테스트케이스가 들어올 때 마다 인덱스에 접근하여 경우의 수를 출력하였다. 


### 구현 배경 지식
1. 메모이제이션
2. 완전 탐색
3. 다이나믹 프로그래밍



### 접근 방법을 적용한 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_9095_lyj {
    static int[] set = {1, 2, 3};
    static int maxLength = 10;
    static int[] numbers = new int[maxLength];
    static int[] answer = new int[maxLength + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= maxLength; i++) {
            generate(0, i);
        }

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(answer[n]).append("\n");
        }
        System.out.println(sb);
    }

    static void generate(int depth, int length) {
        if (depth == length) {
            int sum = 0;
            for (int number : numbers) {
                if (number == 0)
                    break;
                sum += number;
            }
            if (sum <= 10) {
                answer[sum]++;
            }
            return;
        }

        for (int i = 0; i < set.length; i++) {
            numbers[depth] = set[i];
            generate(depth + 1, length);
        }
    }
}
```

