import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        Queue<Integer> st = new LinkedList<>();

        for(int i = 1; i <= n; i ++) {
            st.add(i);
        }

        while(!st.isEmpty()) {
            for(int i = 1; i < m; i ++) {
                int v = st.poll();
                st.add(v);
            }

            int val = st.poll();
            arr.add(val);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i = 0; i < arr.size(); i ++) {
            sb.append(arr.get(i) + ", ");
        }

        sb.setLength(sb.length() - 2);
        sb.append(">");

        bw.write(sb.toString());
        bw.flush();
    }
}
