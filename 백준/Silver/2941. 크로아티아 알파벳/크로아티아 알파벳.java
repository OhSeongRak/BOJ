
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();

		Set<String> set = new HashSet<String>(Arrays.asList("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="));

		String str = br.readLine();
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (i < str.length() - 1 && set.contains(str.substring(i, i + 2))) {
				i++;
			} else if (i < str.length() - 2 && set.contains(str.substring(i, i + 3))) {
				i += 2;
			}
			cnt++;
		}

		System.out.println(cnt);
	} // end of main
}
