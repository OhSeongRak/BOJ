import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();

		int[] mushroom = new int[10];
		for (int i = 0; i < mushroom.length; i++) {
			mushroom[i] = Integer.parseInt(br.readLine());
		}

		int sum = 0;
		for (int i = 0; i < mushroom.length; i++) {
			if (Math.abs(100 - sum - mushroom[i]) <= Math.abs(100 - sum))
				sum += mushroom[i];
            else
                break;
		}
		System.out.println(sum);
	} // end of main
}
