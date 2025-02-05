import java.util.*;
import java.util.Map.*;
import java.io.*;

class Tuple implements Comparable<Tuple> {
    int x;
    int y;
    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Tuple t) {
        if(x != t.x) return x - t.x;
        else return y - t.y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        while(n -- > 0) {
            int val = Integer.parseInt(br.readLine());
            if(val == 0) {
                if(pq.isEmpty()) sb.append(0 + "\n");
                else {
                    Tuple t = pq.poll();
                    sb.append(t.y + "\n");
                }
            }
            else pq.add(new Tuple(Math.abs(val), val));
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
}
