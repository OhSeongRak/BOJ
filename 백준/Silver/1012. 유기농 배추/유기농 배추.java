import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static Queue<XY> q= new LinkedList<>();
    static int[][] graph;
    static int[] xrange ={1,-1,0,0};
    static int[] yrange ={0,0,1,-1};
    static int col;
    static int low;


    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        //StringTokenizer st; // = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            low = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            graph = new int[low][col];
            int baechu = Integer.parseInt(st.nextToken());
            while(baechu -- >0){
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                graph[Integer.parseInt(st1.nextToken())][Integer.parseInt(st1.nextToken())] = 1;
            }
            int count = 0;
            for(int j = 0; j<low; j++){
                for(int k = 0; k<col; k++){
                    if(graph[j][k] == 1) {
                        count++;
                        bfs(j, k);
                    }
                }
            }
            System.out.println(count);
            count = 0;
        }
    }
    public static void bfs(int i, int j){
        q.add(new XY(i, j));
        graph[i][j] = 0;
        while(!q.isEmpty()){
            XY xy = q.poll();
            int x = xy.x;
            int y = xy.y;
            for(int k = 0; k<4; k++){
                int x1 = x + xrange[k];
                int y1 = y + yrange[k];
                if(x1 >=0 && x1<low && y1>= 0 && y1<col && graph[x1][y1] == 1){
                    q.add(new XY(x1, y1));
                    graph[x1][y1] = 0;
                }
            }
        }
    }
}
class XY{
    int x;
    int y;
    XY(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return x + " " + y;
    }

}

