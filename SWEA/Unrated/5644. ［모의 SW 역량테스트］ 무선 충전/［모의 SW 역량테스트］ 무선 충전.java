
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] board;
	static int[][] BCpos;
	static int M, A, answer, r1, r2, c1, c2; // 1: A 위치, 2: B위치
	static int aMove[], bMove[], C[], P[];
	static List<Integer> listA, listB; // 해당 위치에 있는 BC번호를 담을 리스트
	static int[] dr = { 0, -1, 0, 1, 0 };
	static int[] dc = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			input();
			sol();
			System.out.println("#" + test_case + " " + answer);
		}
	}

	private static void sol() {
		// 움직임만큼 반복문
		for (int t = 0; t < aMove.length; t++) {
			r1 += dr[aMove[t]]; // A와 B의 위치 이동 (0번째는 aMove, bMove 둘 다 0으로 초기화 함)
			c1 += dc[aMove[t]];
			r2 += dr[bMove[t]];
			c2 += dc[bMove[t]];
			addBCtoList(r1, c1, r2, c2); // 해당 위치에 BC가 있으면 list에 추가.
			int maxCharge = 0; // 해당 위치에서의 최대 충전량
			if (listA.size() != 0 && listB.size() != 0) { // A, B 둘 다 BC의 범위 내에 있다면
				for (int i = 0; i < listA.size(); i++) {
					for (int j = 0; j < listB.size(); j++) {
						int chargeSum = 0;
						int BCnumA = listA.get(i); // listA의 i번째 인덱스의 BC번호
						int BCnumB = listB.get(j); // listB의 j번째 인덱스의 BC번호

						if (BCnumA == BCnumB) // 둘이 같다면 그냥 BC1개의 성능(P)값
							chargeSum = P[BCnumA];
						else
							chargeSum = P[BCnumA] + P[BCnumB];
						maxCharge = Math.max(maxCharge, chargeSum);
					}
				}
			} else if (listA.size() != 0) {
				for (int i = 0; i < listA.size(); i++)
					maxCharge = Math.max(maxCharge, P[listA.get(i)]);
			} else if (listB.size() != 0) {
				for (int i = 0; i < listB.size(); i++)
					maxCharge = Math.max(maxCharge, P[listB.get(i)]);
			}
			answer += maxCharge;
		}
	}

	private static void addBCtoList(int r1, int c1, int r2, int c2) {
		listA = new ArrayList<Integer>();
		listB = new ArrayList<Integer>();
		for (int i = 0; i < A; i++) {
			if (distance(BCpos[i][0], BCpos[i][1], r1, c1) <= C[i]) // 충전 범위라면 list에 추가
				listA.add(i);
			if (distance(BCpos[i][0], BCpos[i][1], r2, c2) <= C[i])
				listB.add(i);
		}
	}

	private static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	private static void input() throws IOException {
		answer = 0;
		r1 = 1;
		c1 = 1;
		r2 = 10;
		c2 = 10;
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());

		board = new int[11][11];
		aMove = new int[M + 1]; // 맨 앞은 0으로 놔둠
		bMove = new int[M + 1];
		BCpos = new int[A][2];
		C = new int[A];
		P = new int[A];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= M; i++)
			aMove[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= M; i++)
			bMove[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < A; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			BCpos[i][1] = Integer.parseInt(st.nextToken());
			BCpos[i][0] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
	} // end of input
} // end of class
