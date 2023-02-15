
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][][] board;
	static int N, M, R, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		board = new int[2][Math.max(N, M)][Math.max(N, M)];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[0][i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < R; i++) {
			int k = Integer.parseInt(st.nextToken());
			int tmp;
			switch (k) {
			case 1:
				cal1(i % 2);
				break;
			case 2:
				cal2(i % 2);
				break;
			case 3:
				cal3(i % 2);
				tmp = N;
				N = M;
				M = tmp;
				break;
			case 4:
				cal4(i % 2);
				tmp = N;
				N = M;
				M = tmp;
				break;
			case 5:
				cal5(i % 2);
				break;
			case 6:
				cal6(i % 2);
				break;
			}

		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(board[R % 2][i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	} // end of main

	private static void cal1(int k) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[1 - k][i][j] = board[k][N - 1 - i][j];
			}
		}
	}

	private static void cal2(int k) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[1 - k][i][j] = board[k][i][M - 1 - j];
			}
		}
	}

	private static void cal3(int k) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				board[1 - k][i][j] = board[k][N - 1 - j][i];
			}
		}
	}

	private static void cal4(int k) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				board[1 - k][i][j] = board[k][j][M - 1 - i];
			}
		}
	} // end of method

	private static void cal5(int k) {
		// 1 -> 2
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				board[1 - k][i][j] = board[k][i][j - M / 2];
			}
		}

		// 2 -> 3
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				board[1 - k][i][j] = board[k][i - N / 2][j];
			}
		}

		// 3 -> 4
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				board[1 - k][i][j] = board[k][i][j + M / 2];
			}
		}

		// 4 -> 1
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				board[1 - k][i][j] = board[k][i + N / 2][j];
			}
		}
	}

	private static void cal6(int k) {
		// 3 -> 2
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				board[1 - k][i][j] = board[k][i + N / 2][j];
			}
		}

		// 4 -> 3
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				board[1 - k][i][j] = board[k][i][j - M / 2];
			}
		}

		// 1 -> 4
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				board[1 - k][i][j] = board[k][i - N / 2][j];
			}
		}

		// 2 -> 1
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				board[1 - k][i][j] = board[k][i][j + M / 2];
			}
		}
	}
} // end of class
