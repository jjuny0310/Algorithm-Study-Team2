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
