import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int G, N, answer;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] students;

	public static void main(String[] args) throws Exception {
		input();
	}

	private static void sol() {
		if (G == 1) {
			System.out.println(1);
			return;
		}

		int num = 2;
		Set<Integer> set = new HashSet<>();
		loop: while (true) {
			for (int i = 0; i < students.length; i++) {
				if (set.contains(students[i] % num)) {
					set.clear();
					num++;
					continue loop;
				}
				set.add(students[i] % num);
			}
			break;
		}
		System.out.println(num);
	}

	private static void input() throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			G = Integer.parseInt(br.readLine());
			students = new int[G];
			for (int j = 0; j < G; j++)
				students[j] = Integer.parseInt(br.readLine());
			sol();
		}
	} // end of input

}