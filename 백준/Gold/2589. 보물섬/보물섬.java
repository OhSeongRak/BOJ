import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int R, C, answer;
	static char[][] board;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		input();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 'L') {
					visited = new boolean[R][C];
					bfs(i, j);
				}
			}
		}
		System.out.println(answer);
	} // end of main

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] { x, y, 0 });
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			int r = pos[0];
			int c = pos[1];
			int d = pos[2];
			answer = Math.max(d, answer);

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (0 <= nr && nr < R && 0 <= nc && nc < C && !visited[nr][nc]) {
					if (board[nr][nc] == 'W')
						continue;
					visited[nr][nc] = true;
					queue.add(new int[] { nr, nc, d + 1 });
				}
			}
		} // end of while
	} // end of bfs

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		answer = 0;
		visited = new boolean[R][C];
		board = new char[R][];
		for (int i = 0; i < R; i++)
			board[i] = br.readLine().toCharArray();
	} // end of input
} // end of class