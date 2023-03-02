# https://www.acmicpc.net/problem/1753
from collections import defaultdict
import heapq
import sys
input = sys.stdin.readline


def djikstra(start):
    distances[start] = 0
    queue = []
    heapq.heappush(queue, (0, start))

    while queue:
        cur_dis, cur_v = heapq.heappop(queue)

        # queue에서 나온 현재 거리가
        # 최단 거리(distances 리스트에 있는)보다 클 경우
        if distances[cur_v] < cur_dis:
            continue

        for v, dis in graph[cur_v]:
            total_dis = cur_dis + dis
            if total_dis < distances[v]:
                distances[v] = total_dis
                heapq.heappush(queue, (total_dis, v))

    for i in range(1, V+1):
        if distances[i] == INF:
            print("INF")
        else:
            print(distances[i])

    return


INF = 1e8
V, E = map(int, input().split())
start = int(input())
graph = defaultdict(list)
for _ in range(E):
    v1, v2, w = map(int, input().split())
    graph[v1].append((v2, w))
distances = [INF] * (V+1)
djikstra(start)
