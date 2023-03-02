import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int no;
		int weight;

		public Node(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}

		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int V, E, start;
	static List<Node>[] graph;
	static int[] distance; // 출발 정점에서 자신까지 오는 최소 비용
	static boolean[] visited;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		input();
		dijkstra();
		for (int i = 1; i <= V; i++) {
			if (distance[i] == INF)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
		}
	}

	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		Arrays.fill(distance, INF);
		distance[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();

			if (distance[curNode.no] < curNode.weight)
				continue;

			for (Node node : graph[curNode.no]) {
				int total = distance[curNode.no] + node.weight;
				if (total < distance[node.no]) {
					distance[node.no] = total;
					pq.add(new Node(node.no, total));
				}
			}
		}
	} // end of dijkstra

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		graph = new ArrayList[V + 1];
		distance = new int[V + 1];
		visited = new boolean[V + 1];

		for (int i = 1; i <= V; i++)
			graph[i] = new ArrayList<Node>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[s].add(new Node(e, w));
		}
	} // end of input
} // end of class