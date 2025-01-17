import java.io.*;
import java.util.*;

class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n, ans = Integer.MAX_VALUE;
    public static int[][] grid;
    public static ArrayList<Pair> arr = new ArrayList<>();
    public static boolean[][] visited;
    public static boolean[][] tmp;
    public static StringBuilder sb = new StringBuilder();
    public static int[] dx = new int[]{0, -1, 0, 1, 0};
    public static int[] dy = new int[]{0, 0, 1, 0, -1};

    public static int calc() {
        int val = 0;
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= n; j ++) {
                if(tmp[i][j]) val += grid[i][j];
            }
        }

        return val;
    }

    public static boolean inRange(int x, int y) {
        return 1 <= x && 1 <= y && x <= n && y <= n;
    }

    public static boolean possible() {
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= n; j ++) {
                tmp[i][j] = false;
            }
        }

        for(int i = 0; i < arr.size(); i ++) {
            int x = arr.get(i).x;
            int y = arr.get(i).y;
            for(int j = 0; j < 5; j ++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if(inRange(nx, ny)) {
                    tmp[nx][ny] = true;
                }
            }
        }

        int cnt = 0;
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= n; j ++) {
                if(tmp[i][j]) cnt ++;
            }
        }

        if(cnt == 15) return true;
        return false;
    }

    public static void dfs(int depth) {
        if(depth == 3) {
//            for(int i = 0; i < arr.size(); i ++) {
//                sb.append(arr.get(i).x).append(arr.get(i).y).append(" ");
//            }
//            sb.append("\n");
            if(possible()) {
                ans = Math.min(ans, calc());
            }
            return;
        }

        for(int i = 2; i <= n - 1; i ++) {
            for(int j = 2; j <= n - 1; j ++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    arr.add(new Pair(i, j));
                    dfs(depth + 1);
                    visited[i][j] = false;
                    arr.remove(arr.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        grid = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];
        tmp = new boolean[n + 1][n + 1];

        for(int i = 1; i <= n; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j ++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        dfs(0);

        bw.write(ans + "");
        bw.flush();
    }
}
