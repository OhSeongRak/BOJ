
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();
		StringBuilder sb = new StringBuilder();
		int G = Integer.parseInt(br.readLine());
		int n = (int) Math.ceil(Math.sqrt(G));

		// N^2 - G = beforeWeight^2
		// beforeWeight는 최대 N-1
		// N^2 - (N - 1)^2 = G
		// (N + N - 1) * (1) = G (A+B)(A-B) = A^2 - B^2
		// 2*N - 1 > G 라면 더 이상 N이 커져도 값이 나올 수 없음.
		while (n + (n - 1) <= G) {
			double beforeWeight = Math.sqrt((double) n * (double) n - G);
			if (beforeWeight != 0 && Math.ceil(beforeWeight) == beforeWeight)
				sb.append(n).append("\n");
			n++;
		}

		if (sb.length() == 0)
			System.out.println(-1);
		else
			System.out.println(sb.toString());
	} // end of main
}
