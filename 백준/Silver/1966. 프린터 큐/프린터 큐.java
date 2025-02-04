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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            Deque<Tuple> q = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < a; i++) {
                int val = Integer.parseInt(stk.nextToken());
                q.add(new Tuple(val, i));
                pq.add(-val);
            }

            int cnt = 0;
            while (!q.isEmpty()) {
                Tuple t = q.poll();

                if (t.x < -pq.peek()) {
                    q.addLast(t);
                } else {
                    cnt++;
                    pq.poll();

                    if (t.y == b) break;
                }
            }
            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
