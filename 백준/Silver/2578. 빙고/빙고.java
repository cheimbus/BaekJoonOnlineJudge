import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int[][] grid = new int[5][5];
    public static int[][] tmpGrid = new int[5][5];
    public static boolean[][] visited = new boolean[5][5];
    public static int cnt;

    public static void check(int val) {
        for(int i = 0; i < 5; i ++) {
            for(int j = 0; j < 5; j ++) {
                if(val == grid[i][j]) {
                    visited[i][j] = true;
                    return;
                }
            }
        }
    }

    public static boolean bingo() {
        int bingoCnt = 0;

        for(int i = 0; i < 5; i ++) {
            int cnt1 = 0;
            for(int j = 0; j < 5; j ++) {
                if(visited[i][j]) {
                    cnt1 ++;
                    if(cnt1 == 5) bingoCnt ++;
                }
            }
        }

        for(int i = 0; i < 5; i ++) {
            int cnt1 = 0;
            for(int j = 0; j < 5; j ++) {
                if(visited[j][i]) {
                    cnt1 ++;
                    if(cnt1 == 5) bingoCnt ++;
                }
            }
        }

        int cnt2 = 0;
        for(int i = 0; i < 5; i ++) {
            if(visited[i][i]) {
                cnt2 ++;
                if(cnt2 == 5) bingoCnt ++;
            }
        }

        int cnt3 = 0;
        for(int i = 0; i < 5; i ++) {
            if(visited[i][4 - i]) {
                cnt3 ++;
                if(cnt3 == 5) bingoCnt ++;
            }
        }

        if(bingoCnt >= 3) return true;
        else return false;
    }

    public static void impl() {
        for(int i = 0; i < 5; i ++) {
            for(int j = 0; j < 5; j ++) {
                int val = tmpGrid[i][j];
                cnt ++;
                check(val);

                if(bingo()) return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < 5; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j ++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int i = 0; i < 5; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j ++) {
                tmpGrid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        impl();

        bw.write(cnt + "");
        bw.flush();
    }
}