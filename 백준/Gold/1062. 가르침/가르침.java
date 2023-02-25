import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, K;
	static Set<Character> set = new HashSet<>(Arrays.asList('a', 'n', 't', 'i', 'c'));
	static Set<Character>[] setArr;
	static Set<Character> alphaSet = new HashSet<>();
	static char[] alpha;
	static char[] com;
	static int R, answer = 0;

	public static void main(String[] args) throws IOException {
		input();
		if (K < 5) {
			System.out.println(0);
			return;
		}
		
		if (K - 5 >= alpha.length) {
			System.out.println(N);
			return;
		}
		R = K - 5;
		combination(0, 0);
		System.out.println(answer);

	}

	public static void combination(int index, int start) {
		if (index == R) {
			Set<Character> tmp = new HashSet<>();
			for (int i = 0; i < com.length; i++) {
				tmp.add(com[i]);
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (tmp.containsAll(setArr[i]))
					cnt++;
			}
			answer = Math.max(answer, cnt);
			return;
		}

		for (int i = start; i < alpha.length; i++) {
			com[index] = alpha[i];
			combination(index + 1, i + 1);
		}
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		setArr = new HashSet[N];
		for (int i = 0; i < N; i++) {
			setArr[i] = new HashSet<Character>();
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				char k = str.charAt(j);
				if (!set.contains(k)) {
					setArr[i].add(k);
					alphaSet.add(k);
				}
			}
		}
        if(K < 5)
            return;
		com = new char[K - 5];
		alpha = new char[alphaSet.size()];
		int i = 0;
		for (char c : alphaSet) {
			alpha[i++] = c;
		}
	}
}
// a n t i c