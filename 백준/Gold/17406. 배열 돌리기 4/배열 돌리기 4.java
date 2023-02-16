import java.util.*;
import java.io.*;

public class Main {
	static int[][] arr;
	static int min = Integer.MAX_VALUE;
	
	// 순열
	static NodeRowCol[] list;
	static NodeRowCol[] temps;
	static boolean[] v;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int row = Integer.parseInt(st.nextToken()) + 1;
		int col = Integer.parseInt(st.nextToken()) + 1;
		int line = Integer.parseInt(st.nextToken());

		list = new NodeRowCol[line];
		temps = new NodeRowCol[line];
		v = new boolean[line];
		arr = new int[row][col];

		for (int i = 1; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < col; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int idx = 0;
		while (line-- > 0) {
			st = new StringTokenizer(br.readLine());
			int row1 = Integer.parseInt(st.nextToken());
			int col1 = Integer.parseInt(st.nextToken());
			int gap = Integer.parseInt(st.nextToken());

			int sRow = row1 - gap;
			int sCol = col1 - gap;

			NodeRowCol nrc = new NodeRowCol(sRow, sCol, gap * 2);
			list[idx++] = nrc;

		}
		permu(list.length, 0);
		System.out.println(min);
	}

	// 순열
	public static void permu(int limit, int n) {
		if (limit == n) {
			// debug
//			System.out.println();
//			for (int[] arr1 : arr)
//				System.out.println(Arrays.toString(arr1));

			minSum();
			return;
		}

		
		for (int i = 0; i < list.length; i++) {
			if (!v[i]) {
				temps[n] = list[i];
				v[i] = true;
				rotation(list[i].gap, list[i].x, list[i].y);
				permu(limit, n + 1);
				// 로테이션 뒤로 돌려주기.
				backRotation(list[i].gap, list[i].x, list[i].y);
				v[i] = false;
			}
		}
	}

	public static void rotation(int size, int xs, int ys) {
		if (size <= 1)
			return;

		int[] xRange = { 0, 1, 0, -1 }; // 오른쪽부터 시작
		int[] yRange = { 1, 0, -1, 0 };

		Node n = new Node(xs, ys, 0);
		int moveSize = size;
		int nextTemp = 0;
		int four = 4;
		int temp = arr[xs][ys];

		// 이전걸 기억하고,
		// 다음걸 기억하고,
		// 이전걸 다음 위치에 넣는다.
		while (four > 0) {
			n.x += xRange[n.dir];
			n.y += yRange[n.dir];

			nextTemp = arr[n.x][n.y];
			arr[n.x][n.y] = temp;
			temp = nextTemp;

			moveSize--;

			if (moveSize == 0) {
				four--;
				moveSize = size;
				n.dir++;
			}
		}
		rotation(size - 2, xs + 1, ys + 1);
	}

	public static void backRotation(int size, int xs, int ys) {
		if (size <= 1)
			return;

		int[] xRange = { 0, -1, 0, 1 }; // 아래부터 시작
		int[] yRange = { -1, 0, 1, 0 };

		Node n = new Node(xs, ys, 3);
		int moveSize = size;
		int nextTemp = 0;
		int four = 4;
		int temp = arr[xs][ys];

		while (four > 0) {
			n.x += xRange[n.dir];
			n.y += yRange[n.dir];

			nextTemp = arr[n.x][n.y];
			arr[n.x][n.y] = temp;
			temp = nextTemp;

			moveSize--;

			if (moveSize == 0) {
				four--;
				moveSize = size;
				n.dir--;
			}
		}
		backRotation(size - 2, xs + 1, ys + 1);
	}

	// 행에있는 모든수의 합중 최소값
	public static void minSum() {
		for (int i = 1; i < arr.length; i++) {
			int sum = 0;
			for (int j = 1; j < arr[i].length; j++)
				sum += arr[i][j];
			min = Math.min(sum, min);
		}
	}

	static class Node {
		int x, y, dir;

		public Node(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	static class NodeRowCol {
		int x, y, gap;

		public NodeRowCol(int x, int y, int gap) {
			this.gap = gap;
			this.x = x;
			this.y = y;
		}
	}
}
