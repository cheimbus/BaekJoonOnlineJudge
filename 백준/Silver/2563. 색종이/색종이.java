import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 100;
    public static boolean[][] grid = new boolean[MAX_N + 1][MAX_N + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while(n -- > 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            for(int i = x; i < x + 10; i ++)
                for(int j = y; j < y + 10; j ++) {
                    grid[i][j] = true;
                }
        }

        int cnt = 0;
        for(int i = 1; i <= MAX_N; i ++)
            for(int j = 1; j <= MAX_N; j ++) {
                if(grid[i][j]) cnt ++;
            }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}