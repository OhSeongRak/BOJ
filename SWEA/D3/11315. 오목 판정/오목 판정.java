
import java.util.Scanner;

public class Solution {
	static boolean is5mok(char[][] board, int n, int r, int c) {
		// (1, 1) or (1, 0) or (1, -1) .... (-1, 0) or (-1, -1)
		int[] dr = { 1, 1, 1, 0, 0, -1, -1, -1 }; // direct_row
		int[] dc = { 1, 0, -1, 1, -1, 1, 0, -1 }; // direct_column

		loop: for (int i = 0; i < 8; i++) { // 8개의 방향
			int count = 1; // 연속된 오목알의 개수
			int nr = r;
			int nc = c;
			for (int j = 0; j < 4; j++) { // 한 방향으로 4개가 있으면 오목
				nr += dr[i];
				nc += dc[i];

				// 이동한 좌표가 범위 내에 있고, 오목 알이 있다면, count 증가
				if (0 <= nr && nr < n && 0 <= nc && nc < n && board[nr][nc] == 'o') {
					count++;
				} else // 오목 알이 없다면 해당 방향은 끝
					continue loop;

				if (count == 5)
					return true;
			}

		}
		return false;
	} // end of is5mok

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // test_case 수
		loop: for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt(); // 오목판의 크기 n x n
			char[][] board = new char[n][n];
			for (int i = 0; i < board.length; i++) { // 오목판에 정보 입력
				String tmp = sc.next();
				for (int j = 0; j < board[i].length; j++) {
					board[i][j] = tmp.charAt(j);
				}
			}

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (board[i][j] == 'o') { // 순회하다 돌을 발견하면
						if (is5mok(board, n, i, j)) { // 오목인지 확인
							System.out.printf("#%d YES%n", test_case);
							continue loop;
						}

					}
				}
			}
			System.out.printf("#%d NO%n", test_case);
		} // end of test_case

	} // end of main
}
