import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, size, answer, baby_r, baby_c, eat_count;
	static int[][] board;
	static int[] dr = { -1, 0, 0, 1 }; // 위, 왼, 오, 아래 (아기상어가 가는 방향의 우선순위)
	static int[] dc = { 0, -1, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		while (bfs()) {
//			System.out.println(answer);
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(board[i]));
//			}
//			System.out.println("================================");
//			System.out.println();
		}
		System.out.println(answer);
	}

	// 일단 아기상어 위치에서 시작
	// 그 위치에서 bfs로 먹을 수 있는 녀석을 찾음. => 찾았으면 true, 못찾았으면 false
	// false면 끝. 시간 끝
	// true면 다시 해당 위치에서 bfs
	// 크기는 알아서 조절
	// bfs : 범위 체크, 방문 체크, 크기 체크(나보다 작은지, 같으면 지나갈 수 있음, 크면 안됨), 만나면 리턴
	private static boolean bfs() {
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> queue = new ArrayDeque<int[]>();
		PriorityQueue<int[]> fishes = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
		visited[baby_r][baby_c] = true;

		queue.add(new int[] { baby_r, baby_c, 0 });
		int prev_d = 0;
		while (!queue.isEmpty()) {
			int r = queue.peek()[0];
			int c = queue.peek()[1];
			int d = queue.poll()[2];

			if (prev_d < d && fishes.size() != 0) {
				move(fishes);
				return true;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc]) {
					if (size < board[nr][nc])
						continue;
					else if (board[nr][nc] == 0 || size == board[nr][nc]) {
						visited[nr][nc] = true;
						queue.add(new int[] { nr, nc, d + 1 });
					} else {
						fishes.add(new int[] { nr, nc, d + 1 });
					}
				} // end of 분기
			} // end of dr dc
			prev_d = d;
		} // end of while

		if (fishes.size() != 0) {
			move(fishes);
			return true;
		}
		return false;
	}

	private static void move(PriorityQueue<int[]> fishes) {
		int[] fish = fishes.poll();
		baby_r = fish[0];
		baby_c = fish[1];
		board[baby_r][baby_c] = 0;
		eat_count++;
		if (eat_count == size) {
			size++;
			eat_count = 0;
		}
		answer += fish[2];
	}

	private static void input() throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		for (int i = 0; i < board.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < board.length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 9) { // 아기 상어를 찾았으면 싹 다 초기화해버려
					board[i][j] = 0;
					baby_r = i;
					baby_c = j;
					size = 2;
					answer = 0;
					eat_count = 0;
				}
			}
		}
	} // end of input
}