import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int flow, fcol, fnumber;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 2 ^ N
		flow = Integer.parseInt(st.nextToken());
		fcol = Integer.parseInt(st.nextToken());

		int size = (int) Math.pow(2, N);
		recur(size, 0, 0, 0); // 4,4,4
		System.out.println(fnumber);

	}

	public static void recur(int size, int low, int col, int number) {
		if (size == 1) {
			if (low == flow && col == fcol)
				fnumber = number;
			return;
		}
		int lowTemp = low;
		int colTemp = col;

		for (int i = low; i < low + size; i += size / 2) {
			lowTemp += size / 2;
			colTemp += size / 2;
			for (int j = col; j < col + size; j += size / 2) {
				if (flow >= i && flow <= lowTemp && j <= fcol && fcol <= colTemp) {
					recur(size / 2, i, j, number);
				}
				colTemp += size / 2;
				number += size / 2 * size / 2;
			}
			colTemp = col;
		}
	}
}
