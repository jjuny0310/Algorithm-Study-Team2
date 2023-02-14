문제 회고를 위해 알고리즘 풀이 기록을 남깁니다.

# 백준 문제번호 문제제목
[3085 사탕 게임](https://www.acmicpc.net/problem/3085)

### 문제 이해하기
1. 2차원 배열에서 인접한 사탕과 한번만 스왑해서 같은 색으로 이루어진 
사탕의 가장 긴 연속 부분의 최대값을 구하는 문제


### 문제 접근 방법
1. N의 크기가 50이므로 모든 경우의 수를 찾아도 시간이 충분하기 때문에 완전탐색으로 접근하였다.
2. 모든 위치를 확인하는데, 현재 위치에서 상, 하, 좌, 우에 있는 서로 다른 사탕과 스왑한 후
세로와 가로를 탐색하여 같은색으로 이루어진 가장 긴 길이를 찾고 출력하였다.


### 구현 배경 지식
1. 완전탐색(브루트포스)
2. 그래프 탐색(상, 하, 좌, 우)



### 접근 방법을 적용한 코드
```java
import java.util.Scanner;

public class bj_3085_lyj {
    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < input.length(); j++) {
                arr[i][j] = input.charAt(j);
            }
        }
        // 구현
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    char temp;
                    // 인접한 사탕 스왑(다를때만)
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (arr[nx][ny] != arr[x][y]) {
                            temp = arr[x][y];
                            arr[x][y] = arr[nx][ny];
                            arr[nx][ny] = temp;
                        }
                    }

                    // 세로 탐색
                    int count = 0;
                    char prev = '-';
                    for (int row = 0; row < N; row++) {
                        if (prev == arr[row][y]) {
                            count++;
                            answer = Math.max(answer, count);
                            continue;
                        }
                        prev = arr[row][y];
                        count = 1;
                    }
                    // 가로 탐색
                    count = 0;
                    prev = '-';
                    for (int col = 0; col < N; col++) {
                        if (prev == arr[x][col]) {
                            count++;
                            answer = Math.max(answer, count);
                            continue;
                        }
                        prev = arr[x][col];
                        count = 1;
                    }


                    // 끝나면 스왑 복구
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (arr[nx][ny] != arr[x][y]) {
                            temp = arr[x][y];
                            arr[x][y] = arr[nx][ny];
                            arr[nx][ny] = temp;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
```

