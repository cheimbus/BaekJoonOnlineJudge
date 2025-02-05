import java.util.*;
import java.util.Map.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        while(n -- > 0) {
            int val = Integer.parseInt(br.readLine());
            if(val == 0) {
                if(pq.isEmpty()) sb.append(0).append("\n");
                else {
                    sb.append(-pq.poll()).append("\n");
                }
            }
            else {
                pq.add(-val);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
}
