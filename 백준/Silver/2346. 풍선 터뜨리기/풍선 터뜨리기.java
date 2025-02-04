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
        Deque<Tuple> dq = new ArrayDeque<>();

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            dq.add(new Tuple(Integer.parseInt(stk.nextToken()), i));
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            Tuple t = dq.pollFirst();
            sb.append(t.y).append(" ");

            int move = t.x;
            if (dq.isEmpty()) break;

            if (move > 0) {
                for (int i = 1; i < move; i++) {
                    dq.addLast(dq.pollFirst());
                }
            } else {
                for (int i = move; i < 0; i++) {
                    dq.addFirst(dq.pollLast());
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
