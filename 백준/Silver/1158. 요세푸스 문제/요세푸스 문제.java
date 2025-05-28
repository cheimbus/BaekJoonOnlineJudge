import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> dq = new LinkedList<>();

        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        for(int i = 1; i <= n; i ++) {
            dq.addLast(i);
        }

        int cnt = 0;
        while(!dq.isEmpty()) {
            cnt ++;
            int d = dq.pollFirst();
            if(cnt == m) {
                cnt = 0;
                arr.add(d);
            }
            else dq.addLast(d);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i = 0; i < n - 1; i ++) {
            sb.append(arr.get(i) + ", ");
        }
        sb.append(arr.get(n - 1)).append(">");

        bw.write(sb.toString());
        bw.flush();
    }
}