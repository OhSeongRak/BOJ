
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] rotate(int[][] board, int N, int M) {
		int[][] rBoard = new int[N][M]; // 4, 5
		int K = Math.min(N, M) / 2;

		for (int i = 0; i < K; i++) {
			// 상
			for (int j = i; j < M - i - 1; j++)
				rBoard[i][j] = board[i][j + 1];
			// 우
			for (int j = i; j < N - i - 1; j++)
				rBoard[j][M - i - 1] = board[j + 1][M - i - 1];
			// 하
			for (int j = M - i - 1; j > i; j--)
				rBoard[N - i - 1][j] = board[N - i - 1][j - 1];
			// 좌
			for (int j = N - i - 1; j > i; j--)
				rBoard[j][i] = board[j - 1][i];
		}
		return rBoard;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < R; i++) {
			board = rotate(board, N, M);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	} // end of main

}
