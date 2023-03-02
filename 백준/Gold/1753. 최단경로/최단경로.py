import heapq
import sys

input = sys.stdin.readline

inf = int(1e9)

V, e = map(int, input().split())
k = int(input())

graph = [[] for _ in range(V + 1)]
distance = [inf] * (V + 1)

for i in range(e):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))

def dijkstra(k):
    q = []
    heapq.heappush(q, (0, k))  # 목적, 가중
    distance[k] = 0

    while q:
        w, now = heapq.heappop(q)  # 가중, 목적
        if distance[now] < w:  # 큐에서 꺼낸게 더커 그럼 무시.
            continue

        for d_dest, d_w in graph[now]:  # 목적지
            # i는
            # 0번이 목적지
            # 1번이 가중치
            if distance[now] + d_w < distance[d_dest]:
                distance[d_dest] = distance[now] + d_w
                heapq.heappush(q, ( distance[d_dest], d_dest  ))


dijkstra(k)

for i in range(1, V + 1):
    if distance[i] != inf:
        print(distance[i])
    else:
        print("INF")
