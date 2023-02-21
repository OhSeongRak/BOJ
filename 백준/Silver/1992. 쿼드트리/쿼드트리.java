import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int[][] board;
	static StringBuilder sb;

	private static int check(int r, int c, int size) {
		int k = board[r][c];

		for (int i = r, rEnd = r + size; i < rEnd; i++) {
			for (int j = c, cEnd = c + size; j < cEnd; j++) {
				if (k != board[i][j])
					return -1;
			}
		}

		return k;
	}

	public static void cut(int r, int c, int size) {
		int checkNum = check(r, c, size);

		if (checkNum != -1) {
			sb.append(checkNum);
			return;
		}

		sb.append("(");
		int half = size / 2;
		cut(r, c, half);
		cut(r, c + half, half);
		cut(r + half, c, half);
		cut(r + half, c + half, half);

		sb.append(")");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}

		cut(0, 0, N);
		System.out.println(sb.toString());

	} // end of main

}
