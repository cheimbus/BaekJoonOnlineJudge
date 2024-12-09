import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int[][] grid;
    public static int[][] tmp;
    public static boolean[][] visited;
    public static int ans;

    public static void check(int val) {
        for(int i = 0; i < 5; i ++) {
            for(int j = 0; j < 5; j ++) {
                if(val == grid[i][j]) {
                    visited[i][j] = true;
                }
            }
        }
    }

    public static boolean find() {
        int res = 0;

        for(int i = 0; i < 5; i ++) {
            int cnt = 0;
            for(int j = 0; j < 5; j ++) {
                if(visited[i][j]) cnt ++;
            }
            if(cnt == 5) {
                res ++;
            }
        }

        for(int i = 0; i < 5; i ++) {
            int cnt = 0;
            for(int j = 0; j < 5; j ++) {
                if(visited[j][i]) cnt ++;
            }
            if(cnt == 5) res ++;
        }

        int cnt1 = 0;
        for(int i = 0; i < 5; i ++) {
            if(visited[i][i]) cnt1 ++;
        }
        if(cnt1 == 5) res ++;

        int cnt2 = 0;
        for(int i = 4; i >= 0; i --) {
            if(visited[i][4 - i]) cnt2 ++;
        }
        if(cnt2 == 5) res ++;

        if(res >= 3) return true;
        else return false;
    }

    public static void impl() {
        for(int i = 0; i < 5; i ++) {
            for(int j = 0; j < 5; j ++) {
                int val = tmp[i][j];
                check(val);
                ans ++;

                if(find()) return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        grid = new int[5][5];
        tmp = new int[5][5];
        visited = new boolean[5][5];

        for(int i = 0; i < 5; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j ++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int i = 0; i < 5; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j ++) {
                tmp[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        impl();

        bw.write(ans + "");
        bw.flush();
        bw.close();
    }
}