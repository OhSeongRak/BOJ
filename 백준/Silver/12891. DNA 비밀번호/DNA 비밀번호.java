import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();
		StringTokenizer st;
		Map<Character, Integer> format = new HashMap<Character, Integer>();
		format.put('A', 0);
		format.put('C', 1);
		format.put('G', 2);
		format.put('T', 3);

		int[] arr = new int[4];
//		String format = "ACGT";

		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		String DNA = br.readLine();

		st = new StringTokenizer(br.readLine());
		int[] acgt = new int[4];
		for (int i = 0; i < 4; i++) {
			acgt[i] = Integer.parseInt(st.nextToken());
		}

		// 초기화
		for (int i = 0; i < P; i++) {
			char ch = DNA.charAt(i);
			if (format.containsKey(ch))
				arr[format.get(ch)]++;
		}

		int total = 0;

		for (int j = 0; j < 5; j++) {
			if (j == 4) {
				total++;
				break;
			}
			if (arr[j] < acgt[j])
				break;
		}

		loop: for (int i = 1; i < S - P + 1; i++) {

			char prev = DNA.charAt(i - 1);
			char next = DNA.charAt(i + P - 1);

			if (format.containsKey(prev)) {
				arr[format.get(prev)]--;
			}

			if (format.containsKey(next)) {
				arr[format.get(next)]++;
			}

			for (int j = 0; j < 4; j++) {
				if (arr[j] < acgt[j])
					continue loop;
			}

			total++;
		}

		System.out.println(total);

	} // end of main
}

