
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[103][103];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int startC = Integer.parseInt(st.nextToken()) + 1;
			int startR = Integer.parseInt(st.nextToken()) + 1;

			for (int r = startR; r < startR + 10; r++) {
				for (int c = startC; c < startC + 10; c++) {
					board[r][c] = 1;
				}
			}
		}

		int cnt = 0;
		int[] dr = { 1, -1, 0, 0 };
		int[] dc = { 0, 0, 1, -1 };

		for (int r = 0; r <= 102; r++) {
			for (int c = 0; c <= 102; c++) {
				if (board[r][c] == 0) {
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if (0 <= nr && nr <= 102 && 0 <= nc && nc <= 102 && board[nr][nc] == 1)
							cnt++;
					}
				}
			}
		}

		System.out.println(cnt);
	} // end of main
}
