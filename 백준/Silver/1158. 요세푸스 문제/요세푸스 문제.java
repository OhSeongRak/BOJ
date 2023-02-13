import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        //int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int number = Integer.parseInt(st.nextToken());
        int turn = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i<= number; i++){
            q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!q.isEmpty()){
            for(int i= 0; i<turn; i++){
                if(i == turn -1){
                    sb.append(q.poll()).append(", ");
                    break;
                }
                q.offer(q.poll());
            }
        }
        sb.delete(sb.length()-2,sb.length());
        sb.append(">");
        System.out.println(sb);



    }
}

