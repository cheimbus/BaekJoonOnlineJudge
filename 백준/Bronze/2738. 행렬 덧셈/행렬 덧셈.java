import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 100;
    public static int n, m;
    public static int[][] grid1 = new int[MAX_N][MAX_N];
    public static int[][] grid2 = new int[MAX_N][MAX_N];
    public static int[][] ansGrid = new int[MAX_N][MAX_N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        for(int i = 0; i < n; i ++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j ++) {
                int num = Integer.parseInt(stk.nextToken());
                grid1[i][j] = num;
            }
        }

        for(int i = 0; i < n; i ++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j ++) {
                int num = Integer.parseInt(stk.nextToken());
                grid2[i][j] = num;
            }
        }

        for(int i = 0; i < n; i ++)
            for(int j = 0; j < m; j ++) {
                int plus = grid1[i][j] + grid2[i][j];
                ansGrid[i][j] = plus;
            }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j++) {
                sb.append(ansGrid[i][j] + " ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}