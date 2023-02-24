import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static boolean[] visited;
	static boolean possible;
	static List<Integer>[] friends;
	static int N, M;

	public static void main(String[] args) throws IOException {
		input();
		for (int i = 0; i < N; i++) {
			if (possible) {
				System.out.println(1);
				return;
			}
			visited = new boolean[N];
			dfs(1, i);
		}
		System.out.println(0);
	} // end of main

	private static void dfs(int distance, int key) {
		if (possible)
			return;

		if (distance == 5) {
			possible = true;
			return;
		}

		visited[key] = true;
		for (int num : friends[key]) {
			if (!visited[num]) {
				dfs(distance + 1, num);
				visited[num] = false;
			}
		}
	} // end of dfs

	@SuppressWarnings("unchecked")
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		friends = new ArrayList[N];
		for (int i = 0; i < friends.length; i++) {
			friends[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friends[a].add(b);
			friends[b].add(a);
		}
	} // end of input
} // end of class
