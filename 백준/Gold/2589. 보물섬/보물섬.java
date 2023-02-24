
import java.util.*;
import java.io.*;

public class Main {

	static int[][] arr;
	static int[][] arrCopy;
	static int max;
	static Node maxNode;

	static int[] xdir = { 1, -1, 0, 0 };
	static int[] ydir = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());

		arr = new int[row][col];
		arrCopy = new int[row][col];

		for (int i = 0; i < row; i++) {
			String str = br.readLine();
			for (int j = 0; j < col; j++) {
				if (str.charAt(j) == 'W')
					arr[i][j] = 0; // 바다
				else
					arr[i][j] = 1; // 육지
			}
		}

		for (int i = 0; i < row; i++)
			System.arraycopy(arr[i], 0, arrCopy[i], 0, col);
		//System.out.println(Arrays.deepToString(arrCopy));

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (arr[i][j] == 1) {
					bfs(i, j);
					for (int k = 0; k < row; k++)
						System.arraycopy(arrCopy[k], 0, arr[k], 0, col);
				}
			}
		}
		System.out.println(max);
	}

	public static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y, 0));
		arr[x][y] = 0;

		while (!q.isEmpty()) {
			Node n = q.poll();
			
			max = Math.max(max, n.dis);

			for (int i = 0; i < 4; i++) {
				int nx = n.x + xdir[i];
				int ny = n.y + ydir[i];

				if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length) {
					if (arr[nx][ny] == 1) {
						q.offer(new Node(nx, ny, n.dis + 1));
						arr[nx][ny] = 0;
					}
				}
			}
		}
	}

	static class Node {
		int x, y, dis;

		public Node(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}

		public String toString() {
			return x + " " + y;
		}
	}
}
