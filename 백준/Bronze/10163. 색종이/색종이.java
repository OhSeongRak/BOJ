
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[1001][1001];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int startC = Integer.parseInt(st.nextToken());
			int startR = Integer.parseInt(st.nextToken());
			int endC = Integer.parseInt(st.nextToken());
			int endR = Integer.parseInt(st.nextToken());

			for (int r = startR; r < startR + endR; r++) {
				for (int c = startC; c < startC + endC; c++) {
					board[r][c] = i + 1;
				}
			}
		}

		int[] answer = new int[n + 1];
		int cnt = 0;
		for (int r = 0; r < 1001; r++) {
			for (int c = 0; c < 1001; c++) {
				if (board[r][c] != 0)
					answer[board[r][c]]++;
			}
		}

		for (int i = 1; i <= n; i++) {
			System.out.println(answer[i]);
		}

	} // end of main
}
