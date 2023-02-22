
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder stack = new StringBuilder();
		String str = br.readLine();
		boolean flag = false;

		for (int i = 0; i < str.length(); i++) {
			char k = str.charAt(i);

			if (flag) {
				if (k == '>') {
					flag = false;
					sb.append(stack.append(k));
					stack.setLength(0);
				} else
					stack.append(k);
			} else {
				if (k == ' ') {
					sb.append(stack).append(' ');
					stack.setLength(0);
				} else if (k == '<') {
					flag = true;
					sb.append(stack).append('<');
					stack.setLength(0);
				} else
					stack.insert(0, k);
			}

		} // end of for

		if (stack.length() != 0)
			sb.append(stack);

		System.out.println(sb.toString());
	} // end of main
}