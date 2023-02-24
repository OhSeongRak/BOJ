
import java.util.*;
import java.io.*;

public class Main {

	static int[][] arr;
	static boolean[] v;
	static int maxDistance = 1;
	
	static int[] xRange = { 1, 0, -1, 0 };
	static int[] yRange = { 0, 1, 0, -1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());

		arr = new int[row][col];
		v = new boolean[30];

		for (int i = 0; i < row; i++) {
			String str = br.readLine();
			for (int j = 0; j < col; j++) {
				arr[i][j] = str.charAt(j) - 'A';
			}
		}
		
		v[arr[0][0]] = true;
		dfs(0, 0, 1);
		System.out.println(maxDistance);
	}

	// 최대로 이동
	public static void dfs(int x, int y, int moveDistance) {
		maxDistance = Math.max(moveDistance, maxDistance);
		for (int i = 0; i < 4; i++) {
			int nx = x + xRange[i];
			int ny = y + yRange[i];

			if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length) {
				if (!v[arr[nx][ny]]) {
					v[arr[nx][ny]] = true;
					dfs(nx, ny, moveDistance + 1);
					v[arr[nx][ny]] = false;
				}
			}
		}
	}
}