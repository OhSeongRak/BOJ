
import java.util.Scanner;

public class Main {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String x = sc.next();
    String y = sc.next();
    int min = Integer.MAX_VALUE;

    for (int i = 0; i <= y.length() - x.length(); i++) {
        int cnt = 0;
        for (int j = 0; j < x.length(); j++) {
            if (x.charAt(j) != y.charAt(j + i)) {
                cnt++;
            }
        }
        if (min > cnt) {
            min = cnt;
        }
    }

    System.out.println(min);
}
}