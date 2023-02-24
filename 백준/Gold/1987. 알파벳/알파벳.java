
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Set<Character> visited;
	static int R, C, answer;
	static char[][] board;
	static int[] dr = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		input();
		visited = new HashSet<Character>();
		visited.add(board[0][0]);
		dfs(1, 0, 0);
		System.out.println(answer);

	}

	private static void dfs(int cnt, int r, int c) {
		if (cnt > answer)
			answer = cnt;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (0 <= nr && nr < R && 0 <= nc && nc < C && !visited.contains(board[nr][nc])) {
				visited.add(board[nr][nc]);
				dfs(cnt + 1, nr, nc);
				visited.remove(board[nr][nc]);
			}
		}

	} // end of dfs

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < C; j++)
				board[i][j] = tmp.charAt(j);
		}
	} // end of input
} // end of class
