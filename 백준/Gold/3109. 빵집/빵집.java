
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int R, C, answer = 0;
	static char[][] board;
	static boolean[][] visited;
	static boolean finished;
	static int[] dr = { -1, 0, 1 }; // 우상, 우, 우하 => 파이프라인이 도달하는 최적의 순서. 뒤로는 갈 필요 없음
	static int[] dc = { 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		input();
		for (int i = 0; i < R; i++) {
			finished = false;
			dfs(i, 0);
		}
		System.out.println(answer);
	} // end of main

	public static void dfs(int r, int c) {
		if (c == C - 1 && !finished) {
			visited[r][c] = true;
			answer++;
			finished = true;
			return;
		}

		for (int i = 0; i < 3; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (!finished && 0 <= nr && nr < R && 0 <= nc && nc < C && board[nr][nc] == '.' && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
		}
	}

	public static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < C; j++)
				board[i][j] = tmp.charAt(j);
		}
	} // end of input
} // end of class
