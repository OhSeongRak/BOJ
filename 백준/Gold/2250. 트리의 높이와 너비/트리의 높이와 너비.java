import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[] tree;
	static int[][] input;
	static int[][] nodePos;
//	static int[][] H;
	static int[] levels;
	static int N, idx, root, maxDepth, level, answer;

	public static void main(String[] args) throws IOException {
		input();
		sol();
	}

	private static void sol() {
		makeTree();
		inorder(root, 1);
		for (int i = 1; i <= N; i++) {
			int leftDepth = levels[i];
			int r = N;
			while (i <= r) {
				if (leftDepth == levels[r])
					break;
				r--;
			}
			int tmp = r - i + 1;
			if (answer < tmp || answer == tmp && leftDepth < level) {
				level = leftDepth;
				answer = tmp;
			}
		}
		System.out.println(level + " " + answer);
	}

	private static void inorder(int v, int depth) {
		if (input[v][0] != -1)
			inorder(input[v][0], depth + 1);
		levels[++idx] = depth;
		if (input[v][1] != -1)
			inorder(input[v][1], depth + 1);

	}

	private static void makeTree() {
		loop: for (int child = 1; child <= N; child++) {
			for (int i = 1; i <= N; i++) {
				if (input[i][0] == child || input[i][1] == child)
					continue loop;
			}
			root = child;
			return;
		}
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new int[64];
		nodePos = new int[N + 1][2];
		input = new int[N + 1][2];
		levels = new int[N + 1];
//		H = new int[N + 1][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			input[p][0] = Integer.parseInt(st.nextToken());
			input[p][1] = Integer.parseInt(st.nextToken());
//			System.out.println(Arrays.toString(input[i+1]));
		}

	} // end of input

} // end of class