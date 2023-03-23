문제 회고를 위해 알고리즘 풀이 기록을 남깁니다.

# 백준 문제번호 문제제목
[토마토 7569](https://www.acmicpc.net/problem/7569)

### 문제 이해하기
토마토를 보관하는 상자가 3차원 리스트로 주어진다. 각 원소는 익은 토마토, 안익은 토마토, 비어있는 곳
3가지로 구분되며, 익은 토마토의 "상, 하, 좌, 우, 앞, 뒤"에 안익은 토마토가 있다면 안익은 토마토는
다음날 익은 토마토로 변하게 된다.
상자안에 모든 토마토가 다 익는데 며칠이 걸리는지 구하는 문제이다. 단, 한 곳이라도 비어있으면 -1을 출력한다.

 

### 문제 접근 방법
1. 초기에는 BFS를 기반으로 하는 완전탐색으로 접근하였다. 날짜를 나타내는 변수 day를 1로 초기화하였고,
3차원 리스트를 전체적으로 순회하면서 해당 위치가 day와 같다면 상, 하, 좌, 우, 앞, 뒤를 탐색하여
안익은 토마토가 있다면 현재 위치에 +1을 더하여 갱신하는 방식으로 문제를 접근하였다.
변화한 토마토가 없다면, 반복문을 종료하여 결과를 출력하였다.

하지만, 시간초과가 발생하였다. 100 * 100 * 100 => 100만의 원소를 매 주기마다 탐색하기 때문에
시간초과가 발생하였다.

2. Queue를 사용하여 1번 과정의 소요 시간을 최적화 하였다. Queue를 토마토가 있는 위치들로 초기화하였고,
이후 토마토로 값이 갱신된 위치만 Queue에 할당하는 방법으로 접근하였다. 결국 한번 방문한 위치는
다시는 방문하지 않기 때문에 O(N)의 시간복잡도로 시간초과 문제가 해결되었다.


### 구현 배경 지식
1. BFS
2. 완전탐색



### 접근 방법을 적용한 코드
```python
from collections import deque


def bfs(graph, visited):
    queue = deque()
    for z in range(H):
        for x in range(N):
            for y in range(M):
                if graph[z][x][y] == 1:
                    queue.append((x, y, z, 0))
                    visited[z][x][y] = True

    res = 0
    while queue:
        x, y, z, dist = queue.popleft()

        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]
            if 0 <= nx < N and 0 <= ny < M and 0 <= nz < H:
                if not visited[nz][nx][ny] and graph[nz][nx][ny] == 0:
                    graph[nz][nx][ny] = 1
                    visited[nz][nx][ny] = True
                    queue.append((nx, ny, nz, dist + 1))
                    res = max(res, dist + 1)

    return res


M, N, H = map(int, input().split())

graph = []

for _ in range(H):
    temp = []
    for _ in range(N):
        temp.append(list(map(int, input().split())))

    graph.append(temp)

day = 1
dx = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]
dz = [0, 0, 0, 0, -1, 1]

visited = [[[False] * M for _ in range(N)] for _ in range(H)]
answer = bfs(graph, visited)

fail = False
for z in range(H):
    for x in range(N):
        for y in range(M):
            if graph[z][x][y] == 0:
                fail = True
if fail:
    print(-1)
else:
    print(answer)

```

