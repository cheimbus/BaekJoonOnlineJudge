import java.util.*;
import java.io.*;

class Tuple {
    int x;
    int y;
    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n, m;
    public static int time = Integer.MAX_VALUE;
    public static int max = 100_000;
    public static boolean[] visited;
    public static Queue<Tuple> q = new LinkedList<>();

    public static void bfs() {
        while(!q.isEmpty()) {
            Tuple t = q.poll();
            int x = t.x;
            int y = t.y;
            visited[x] = true;
            if(m == x) time = Math.min(time, y);

            if(x * 2 <= max && !visited[x * 2]) q.add(new Tuple(x * 2, y));
            if(x + 1 <= max && !visited[x + 1]) q.add(new Tuple(x + 1, y + 1));
            if(x - 1 >= 0 && !visited[x - 1]) q.add(new Tuple(x - 1, y + 1));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        visited = new boolean[max + 1];

        q.add(new Tuple(n, 0));
        bfs();

        bw.write(time + "");
        bw.flush();
        br.close();
    }
}
