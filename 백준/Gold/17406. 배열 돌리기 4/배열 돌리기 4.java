
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, r, c, s, answer = Integer.MAX_VALUE;
	static int[][] board;
	static int[][] originBoard;
	static int[][] rBoard;
	static int[][] operate;
	static int[] order;
	static boolean[] isSelected;

	public static void copy() {
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= M; j++)
				board[i][j] = originBoard[i][j];
	}

	public static void permutation(int cnt) {
		if (cnt == K) {
			copy();
			for (int o : order) {
				rotate(operate[o][0], operate[o][1], operate[o][2]);
			}
			answer = Math.min(answer, min());
			return;
		}

		for (int i = 0; i < K; i++) { // cnt 칸에 넣을 수 있는 숫자를 하나씩 넣어보자
			if (isSelected[i]) // numbers[] // 0 ~ cnt-1에 사용하지 않은 숫자를 찾아서 쓰기
				continue;
			order[cnt] = i;
			isSelected[i] = true;
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	} // end of perm

	public static int min() {
		int ret = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 0; j <= M; j++) {
				sum += board[i][j];
			}
			ret = Math.min(ret, sum);
		}
		return ret;
	}

	public static void rotate(int r, int c, int s) {
		int x = r - s; // 시작점
		int y = c - s;
		int n = 2 * s + 1; // 사각형 크기

		for (int i = 0; i < s; i++) { // 껍질 개수만큼 반복
			// 상
			for (int j = i; j < n - i - 1; j++)
				rBoard[i + x][j + 1 + y] = board[i + x][j + y];
			// 우
			for (int j = i; j < n - i - 1; j++)
				rBoard[j + 1 + x][n - i - 1 + y] = board[j + x][n - i - 1 + y];
			// 하
			for (int j = n - i - 1; j > i; j--)
				rBoard[n - i - 1 + x][j - 1 + y] = board[n - i - 1 + x][j + y];
			// 좌
			for (int j = n - i - 1; j > i; j--)
				rBoard[j - 1 + x][i + y] = board[j + x][i + y];

			rBoard[r][c] = board[r][c];
		}

		for (int i = x; i <= r + s; i++)
			for (int j = y; j <= c + s; j++)
				board[i][j] = rBoard[i][j];

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[N + 1][M + 1];
		originBoard = new int[N + 1][M + 1];
		rBoard = new int[N + 1][M + 1];
		operate = new int[K][3];
		order = new int[K];
		isSelected = new boolean[K];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				originBoard[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			operate[i][0] = Integer.parseInt(st.nextToken());
			operate[i][1] = Integer.parseInt(st.nextToken());
			operate[i][2] = Integer.parseInt(st.nextToken());
		}

		permutation(0);
		System.out.println(answer);

	} // end of main
}
