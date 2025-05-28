import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> dq = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i ++) {
            dq.addLast(i);
        }

        while(dq.size() != 1) {
            dq.pollFirst();
            int a = dq.pollFirst();
            dq.addLast(a);
        }

        bw.write(dq.pollFirst() + "");
        bw.flush();
    }
}