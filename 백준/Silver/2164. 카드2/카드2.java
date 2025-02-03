import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 1; i <= n; i ++) {
            q.add(i);
        }

        while(q.size() != 1) {
            q.poll();
            int v = q.poll();
            q.add(v);
        }

        bw.write(q.poll() + "");
        bw.flush();
    }
}
