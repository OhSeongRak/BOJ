
import java.util.*;
import java.io.*;

/* TODO:
 * 
 *
 * */
public class Main {
	static boolean[] v = new boolean[6];
	static int[][] score = new int[6][3];
	static boolean isPos;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		tc : 
		for (int k = 0; k < 4; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 6; i++) {
				int sum = 0;
				for (int j = 0; j < 3; j++) {
					score[i][j] = Integer.parseInt(st.nextToken());
					sum += score[i][j]; 
				}
				if(sum != 5) {
					sb.append(0).append(" ");
					continue tc;
				}
					
			}

			isPos = false;
			dfs(0, 0, 0, 0, 0);
			
			sb.append(isPos? 1: 0).append(" ");
		}
		System.out.println(sb.toString());
	}

	public static void dfs(int count, int t1, int t2, int point1, int point2) {
		if(point1 < 0 || point2 < 0)
			return;
		
		if (count == 15) {
			isPos = true;
			return;
		}
		
		// 팀 선택
		t2++;
		if(t2 == 6) {
			t1++;
			t2 = t1 + 1;
		}
				
		// 승패
		score[t1][0]--; score[t2][2]--;
		dfs(count + 1, t1, t2, score[t1][0], score[t2][2]);
		score[t1][0]++; score[t2][2]++;
		// 무
		score[t1][1]--; score[t2][1]--;
		dfs(count + 1, t1, t2, score[t1][1], score[t2][1]);
		score[t1][1]++; score[t2][1]++;
		// 패승
		score[t1][2]--; score[t2][0]--;
		dfs(count + 1, t1, t2, score[t1][2], score[t2][0]);
		score[t1][2]++; score[t2][0]++;
	}
}

