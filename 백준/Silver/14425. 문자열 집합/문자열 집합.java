import java.util.*;
import java.util.Map.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int cnt = 0;

        HashSet<String> hs = new HashSet<>();
        PriorityQueue<String> pq = new PriorityQueue<>();
        while(n -- > 0) {
            String s = br.readLine();
            hs.add(s);
        }

        for(int i = 0; i < m; i ++) {
            String s = br.readLine();
            pq.add(s);
        }

        while(!pq.isEmpty()) {
            String s = pq.poll();
            if(hs.contains(s)) cnt ++;
        }

        bw.write(cnt + "");
        bw.flush();
        br.close();
    }
}
