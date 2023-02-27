import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, cnt;
	static int outsideX, outCnt, inCnt; // 가장 바깥 봉우리의 오른쪽 X좌표, 다른 봉우리에 의해 포함되지 않는 봉우리, 포함하지 않는 봉우리
	static boolean isIn;
	static List<int[]> pos = new ArrayList<>();
	static List<int[]> bong = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		sol();
	}

	private static void sol() {
		int startX = 0;
		for (int i = 0; i < pos.size() - 1; i++) {
			int[] cur = pos.get(i);
			int[] next = pos.get(i + 1);
			if (cur[1] < 0 && next[1] > 0) { // 경계선을 뚫고 올라왔을 경우
				startX = cur[0];
			} else if (cur[1] > 0 && next[1] < 0) { // 경계선을 뚫고 내려갔을 경우
				bong.add(new int[] { Math.min(startX, cur[0]), Math.max(startX, cur[0]) });
			}
		}

		Collections.sort(bong, (o1, o2) -> o1[0] - o2[0]); // 왼쪽 x순으로 정렬
//		for (int i = 0; i < bong.size(); i++) {
//			System.out.println(Arrays.toString(bong.get(i)));
//		}

		countOutside();
		countInside();

		System.out.println(outCnt + " " + inCnt);
	}

	private static void countInside() {
		inCnt = 1;
		int curX = bong.get(0)[1]; // 가장 안쪽 봉우리의 오른쪽 x값

		for (int i = 1; i < bong.size(); i++) {
			if (curX < bong.get(i)[1]) // 가장 안쪽 봉우리의 X보다 더 뒤에 있다면
				inCnt++;
			curX = bong.get(i)[1];
		}
	}

	private static void countOutside() {
		outCnt = 1;
		int curX = bong.get(0)[1]; // 바깥 봉우리의 오른쪽 x값

		for (int i = 1; i < bong.size(); i++) {
			if (bong.get(i)[1] < curX)
				continue;
			outCnt++;
			curX = bong.get(i)[1];
		}
	}

	private static void input() throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			pos.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}

		while (pos.get(0)[1] > 0) { // y좌표가 음수인 위치부터 시작하기 위해
			pos.add(pos.get(0));
			pos.remove(pos.get(0));
		}
		pos.add(pos.get(0)); // 시작 위치로 돌아오기 때문에 시작 위치 맨 뒤에 삽입

//		for (int i = 0; i < pos.size(); i++) {
//			System.out.println(Arrays.toString(pos.get(i)));
//		}
	} // end of input
}