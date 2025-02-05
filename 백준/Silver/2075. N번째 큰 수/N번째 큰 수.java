import java.util.*;
import java.util.Map.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j ++) {
                pq.add(-Integer.parseInt(stk.nextToken()));
            }
        }

        while(n -- > 1) {
            pq.poll();
        }

        bw.write(-pq.poll() + "");
        bw.flush();
        br.close();
    }
}
