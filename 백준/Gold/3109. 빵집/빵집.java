
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
	static boolean finished; // 마지막 열에 도달했는지 파악
	static int[] dr = { -1, 0, 1 }; // 우상, 우, 우하 => 파이프라인이 도달하는 최적의 순서.
	static int[] dc = { 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		input();
		for (int i = 0; i < R; i++) { // 첫번째 열만 확인하면 됨.
			finished = false;
			dfs(i, 0);
		}
		System.out.println(answer);
	} // end of main

	public static void dfs(int r, int c) {
		if (finished) // 이미 마지막열에 도달 했으면 return
			return;

		visited[r][c] = true; // 방문 처리
		if (c == C - 1) { // 마지막 열에 도달했으면
			answer++;
			finished = true;
			return;
		}

		for (int i = 0; i < 3; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// (nr, nc)가 범위 내인가? 해당 위치가 '.'인가? 방문 안했는가? -> OK 들어가
			if (0 <= nr && nr < R && 0 <= nc && nc < C && board[nr][nc] == '.' && !visited[nr][nc]) {
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
