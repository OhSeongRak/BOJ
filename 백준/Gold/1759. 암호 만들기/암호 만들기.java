import java.io.*;
import java.math.BigInteger; // subtract , multiply, add, mod
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static String[] temp;
    static String[] arr;
    static int len;
    static int strs;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        len = Integer.parseInt(st.nextToken());
        strs = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        arr = new String[strs];
        temp = new String[len];

        int idx = 0;
        while (st.hasMoreTokens())
            arr[idx++] = st.nextToken();


        bt(len, 0, 0);
        list.sort((o1, o2) -> o1.compareTo(o2));

        for(String s : list){
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }

    // a e i o u // 1개 ~ 3개
    // 조합
    public static void bt(int limit , int n , int idx){
        if(limit == n){
            String[] st1 = new String[len];
            int counts = 0;
            int st1idx = 0;
            for(String e : temp){
                st1[st1idx++] = e;
                if(e.equals("a") || e.equals("e") || e.equals("i") || e.equals("o") || e.equals("u"))
                    counts++;
            }
            if(counts >= 1 && counts <= len - 2){
                Arrays.sort(st1);
                StringBuilder sb = new StringBuilder();
                for(String s : st1)
                    sb.append(s);
                list.add(sb.toString());
            }

            return;
        }

        for(int i = idx; i<strs ; i++){
            temp[n] = arr[i];
            bt(limit, n+1, i + 1);
        }


    }
}